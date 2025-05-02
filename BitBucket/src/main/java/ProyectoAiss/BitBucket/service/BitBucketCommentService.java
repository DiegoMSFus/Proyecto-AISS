package ProyectoAiss.BitBucket.service;

import ProyectoAiss.BitBucket.etl.TransformerBitBucket;
import ProyectoAiss.BitBucket.model.BitBucket.BComment;
import ProyectoAiss.BitBucket.model.BitBucket.IssueData.BIComments;
import ProyectoAiss.BitBucket.model.BitBucket.IssueData.CommentsPage;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class BitBucketCommentService {

    private final RestTemplate restTemplate;
    private final TransformerBitBucket transformer;

    public BitBucketCommentService(RestTemplate restTemplate, TransformerBitBucket transformer) {
        this.restTemplate = restTemplate;
        this.transformer = transformer;
    }

    public List<BComment> fetchComments(String commentsUrl, int maxPages) {
        List<BComment> comments = new ArrayList<>();

        for (int page = 1; page <= maxPages; page++) {
            String url = commentsUrl + "?page=" + page;

            CommentsPage response = restTemplate.getForObject(url, CommentsPage.class);

            if (response != null && response.values != null) {
                for (BIComments rawComment : response.values) {
                    comments.add(transformer.transformComment(rawComment));
                }

                if (response.next == null) break;
            } else {
                break;
            }
        }

        return comments;
    }
}
