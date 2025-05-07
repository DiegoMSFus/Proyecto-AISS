
package aiss.GitHub.model.IssueData;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "repository_url",
    "labels_url",
    "comments_url",
    "events_url",
    "html_url",
    "id",
    "node_id",
    "number",
    "title",
    "user",
    "labels",
    "state",
    "locked",
    "assignee",
    "assignees",
    "milestone",
    "comments",
    "created_at",
    "updated_at",
    "closed_at",
    "author_association",
    "type",
    "active_lock_reason",
    "sub_issues_summary",
    "body",
    "closed_by",
    "reactions",
    "timeline_url",
    "performed_via_github_app",
    "state_reason"
})
@Generated("jsonschema2pojo")
public class IssueData {

    @JsonProperty("url")
    public String url;
    @JsonProperty("repository_url")
    public String repositoryUrl;
    @JsonProperty("labels_url")
    public String labelsUrl;
    @JsonProperty("comments_url")
    public String commentsUrl;
    @JsonProperty("events_url")
    public String eventsUrl;
    @JsonProperty("html_url")
    public String htmlUrl;
    @JsonProperty("id")
    public Long id;
    @JsonProperty("node_id")
    public String nodeId;
    @JsonProperty("number")
    public Integer number;
    @JsonProperty("title")
    public String title;
    @JsonProperty("user")
    public User user;
    @JsonProperty("labels")
    public List<Label> labels;
    @JsonProperty("state")
    public String state;
    @JsonProperty("locked")
    public Boolean locked;
    @JsonProperty("assignee")
    public Object assignee;
    @JsonProperty("assignees")
    public List<Object> assignees;
    @JsonProperty("milestone")
    public Object milestone;
    @JsonProperty("comments")
    public Integer comments;
    @JsonProperty("created_at")
    public String createdAt;
    @JsonProperty("updated_at")
    public String updatedAt;
    @JsonProperty("closed_at")
    public Object closedAt;
    @JsonProperty("author_association")
    public String authorAssociation;
    @JsonProperty("type")
    public Object type;
    @JsonProperty("active_lock_reason")
    public Object activeLockReason;
    @JsonProperty("sub_issues_summary")
    public SubIssuesSummary subIssuesSummary;
    @JsonProperty("body")
    public String body;
    @JsonProperty("closed_by")
    public Object closedBy;
    @JsonProperty("reactions")
    public Reactions reactions;
    @JsonProperty("timeline_url")
    public String timelineUrl;
    @JsonProperty("performed_via_github_app")
    public Object performedViaGithubApp;
    @JsonProperty("state_reason")
    public Object stateReason;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(IssueData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("url");
        sb.append('=');
        sb.append(((this.url == null)?"<null>":this.url));
        sb.append(',');
        sb.append("repositoryUrl");
        sb.append('=');
        sb.append(((this.repositoryUrl == null)?"<null>":this.repositoryUrl));
        sb.append(',');
        sb.append("labelsUrl");
        sb.append('=');
        sb.append(((this.labelsUrl == null)?"<null>":this.labelsUrl));
        sb.append(',');
        sb.append("commentsUrl");
        sb.append('=');
        sb.append(((this.commentsUrl == null)?"<null>":this.commentsUrl));
        sb.append(',');
        sb.append("eventsUrl");
        sb.append('=');
        sb.append(((this.eventsUrl == null)?"<null>":this.eventsUrl));
        sb.append(',');
        sb.append("htmlUrl");
        sb.append('=');
        sb.append(((this.htmlUrl == null)?"<null>":this.htmlUrl));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("nodeId");
        sb.append('=');
        sb.append(((this.nodeId == null)?"<null>":this.nodeId));
        sb.append(',');
        sb.append("number");
        sb.append('=');
        sb.append(((this.number == null)?"<null>":this.number));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("user");
        sb.append('=');
        sb.append(((this.user == null)?"<null>":this.user));
        sb.append(',');
        sb.append("labels");
        sb.append('=');
        sb.append(((this.labels == null)?"<null>":this.labels));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null)?"<null>":this.state));
        sb.append(',');
        sb.append("locked");
        sb.append('=');
        sb.append(((this.locked == null)?"<null>":this.locked));
        sb.append(',');
        sb.append("assignee");
        sb.append('=');
        sb.append(((this.assignee == null)?"<null>":this.assignee));
        sb.append(',');
        sb.append("assignees");
        sb.append('=');
        sb.append(((this.assignees == null)?"<null>":this.assignees));
        sb.append(',');
        sb.append("milestone");
        sb.append('=');
        sb.append(((this.milestone == null)?"<null>":this.milestone));
        sb.append(',');
        sb.append("comments");
        sb.append('=');
        sb.append(((this.comments == null)?"<null>":this.comments));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null)?"<null>":this.updatedAt));
        sb.append(',');
        sb.append("closedAt");
        sb.append('=');
        sb.append(((this.closedAt == null)?"<null>":this.closedAt));
        sb.append(',');
        sb.append("authorAssociation");
        sb.append('=');
        sb.append(((this.authorAssociation == null)?"<null>":this.authorAssociation));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("activeLockReason");
        sb.append('=');
        sb.append(((this.activeLockReason == null)?"<null>":this.activeLockReason));
        sb.append(',');
        sb.append("subIssuesSummary");
        sb.append('=');
        sb.append(((this.subIssuesSummary == null)?"<null>":this.subIssuesSummary));
        sb.append(',');
        sb.append("body");
        sb.append('=');
        sb.append(((this.body == null)?"<null>":this.body));
        sb.append(',');
        sb.append("closedBy");
        sb.append('=');
        sb.append(((this.closedBy == null)?"<null>":this.closedBy));
        sb.append(',');
        sb.append("reactions");
        sb.append('=');
        sb.append(((this.reactions == null)?"<null>":this.reactions));
        sb.append(',');
        sb.append("timelineUrl");
        sb.append('=');
        sb.append(((this.timelineUrl == null)?"<null>":this.timelineUrl));
        sb.append(',');
        sb.append("performedViaGithubApp");
        sb.append('=');
        sb.append(((this.performedViaGithubApp == null)?"<null>":this.performedViaGithubApp));
        sb.append(',');
        sb.append("stateReason");
        sb.append('=');
        sb.append(((this.stateReason == null)?"<null>":this.stateReason));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
