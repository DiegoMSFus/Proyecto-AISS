package aiss.github.service;

import aiss.github.etl.Transformer;
import aiss.github.model.Commit;
import aiss.github.model.commitdata.CommitData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CommitService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Transformer transformer;

    @Value("${github.token}")
    private String token;

    @Value("${github.baseuri}")
    private String baseUri;

    public List<Commit> sinceCommits(String owner, String repo, Integer days, Integer pages) {
        LocalDate sinceDate = LocalDate.now().minusDays(days);
        String uri = baseUri + owner + "/" + repo + "/commits?since=" + sinceDate + "&page=1";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<Void> request = new HttpEntity<>(headers);

        List<Commit> allCommits = new ArrayList<>();
        int currentPage = 1;

        while (uri != null && currentPage <= pages) {
            System.out.println("Fetching: " + uri);
            ResponseEntity<CommitData[]> response = restTemplate.exchange(
                    uri, HttpMethod.GET, request, CommitData[].class);

            if (response.getBody() != null) {
                List<Commit> transformedCommits = Arrays.stream(response.getBody())
                        .map(transformer::transformCommit)
                        .toList();
                allCommits.addAll(transformedCommits);
            }

            uri = getNextPageUrl(response.getHeaders());
            currentPage++;
        }

        return allCommits;
    }

    private String getNextPageUrl(HttpHeaders headers) {
        List<String> linkHeaders = headers.get("Link");
        if (linkHeaders == null || linkHeaders.isEmpty()) return null;

        // Ejemplo: <https://api.github.com/...&page=2>; rel="next", ...
        for (String linkHeader : linkHeaders) {
            String[] parts = linkHeader.split(", ");
            for (String part : parts) {
                String[] section = part.split("; ");
                if (section.length == 2 && section[1].equals("rel=\"next\"")) {
                    return section[0].substring(1, section[0].length() - 1); // quitar < >
                }
            }
        }

        return null;
    }
}
