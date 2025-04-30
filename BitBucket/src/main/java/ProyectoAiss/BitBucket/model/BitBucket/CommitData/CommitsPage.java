package ProyectoAiss.BitBucket.model.BitBucket.CommitData;

import ProyectoAiss.BitBucket.model.BitBucket.BCommit;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommitsPage {

    @JsonProperty("values")
    public List<BCCommitData> values;

    @JsonProperty("next")
    public String next;
}

