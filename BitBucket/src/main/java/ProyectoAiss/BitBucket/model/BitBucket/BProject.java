
package ProyectoAiss.BitBucket.model.BitBucket;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "BProject")
public class BProject {

    @Id
    @JsonProperty("id")
    public String id;

    @JsonProperty("name")
    @NotEmpty(message = "The name of the project cannot be empty")
    public String name;

    @JsonProperty("web_url")
    @NotEmpty(message = "The URL of the project cannot be empty")
    public String webUrl;
    @JsonProperty("BCommits")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectId")
    private List<BCommit> BCommits;

    @JsonProperty("BIssues")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectId")
    private List<BIssue> BIssues;

    public BProject() {
        BCommits = new ArrayList<>();
        BIssues = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public List<BCommit> getCommits() {
        return BCommits;
    }

    public void setCommits(List<BCommit> BCommits) {
        this.BCommits = BCommits;
    }

    public List<BIssue> getIssues() {
        return BIssues;
    }

    public void setIssues(List<BIssue> BIssues) {
        this.BIssues = BIssues;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(BProject.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("BCommits");
        sb.append('=');
        sb.append(((this.BCommits == null)?"<null>":this.BCommits));
        sb.append(',');
        sb.append("BIssues");
        sb.append('=');
        sb.append(((this.BIssues == null)?"<null>":this.BIssues));
        sb.append(',');

        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}