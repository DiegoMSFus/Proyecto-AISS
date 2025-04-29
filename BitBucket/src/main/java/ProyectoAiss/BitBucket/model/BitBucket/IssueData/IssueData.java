
package ProyectoAiss.BitBucket.model.BitBucket.IssueData;

import ProyectoAiss.BitBucket.model.BitBucket.CommitData.Links;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "id",
    "repository",
    "links",
    "title",
    "content",
    "reporter",
    "assignee",
    "created_on",
    "edited_on",
    "updated_on",
    "state",
    "kind",
    "milestone",
    "component",
    "priority",
    "version",
    "votes",
    "watches"
})

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueData {

    @JsonProperty("type")
    public String type;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("repository")
    public Repository repository;
    @JsonProperty("links")
    public Links links;
    @JsonProperty("title")
    public String title;
    @JsonProperty("content")
    public Content content;
    @JsonProperty("reporter")
    public Reporter reporter;
    @JsonProperty("assignee")
    public Object assignee;
    @JsonProperty("created_on")
    public String createdOn;
    @JsonProperty("edited_on")
    public Object editedOn;
    @JsonProperty("updated_on")
    public String updatedOn;
    @JsonProperty("state")
    public String state;
    @JsonProperty("kind")
    public String kind;
    @JsonProperty("milestone")
    public Object milestone;
    @JsonProperty("priority")
    public String priority;
    @JsonProperty("version")
    public Object version;
    @JsonProperty("votes")
    public Integer votes;
    @JsonProperty("watches")
    public Integer watches;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(IssueData.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("repository");
        sb.append('=');
        sb.append(((this.repository == null)?"<null>":this.repository));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("content");
        sb.append('=');
        sb.append(((this.content == null)?"<null>":this.content));
        sb.append(',');
        sb.append("reporter");
        sb.append('=');
        sb.append(((this.reporter == null)?"<null>":this.reporter));
        sb.append(',');
        sb.append("assignee");
        sb.append('=');
        sb.append(((this.assignee == null)?"<null>":this.assignee));
        sb.append(',');
        sb.append("createdOn");
        sb.append('=');
        sb.append(((this.createdOn == null)?"<null>":this.createdOn));
        sb.append(',');
        sb.append("editedOn");
        sb.append('=');
        sb.append(((this.editedOn == null)?"<null>":this.editedOn));
        sb.append(',');
        sb.append("updatedOn");
        sb.append('=');
        sb.append(((this.updatedOn == null)?"<null>":this.updatedOn));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(((this.state == null)?"<null>":this.state));
        sb.append(',');
        sb.append("kind");
        sb.append('=');
        sb.append(((this.kind == null)?"<null>":this.kind));
        sb.append(',');
        sb.append("milestone");
        sb.append('=');
        sb.append(((this.milestone == null)?"<null>":this.milestone));
        sb.append(',');
        sb.append("priority");
        sb.append('=');
        sb.append(((this.priority == null)?"<null>":this.priority));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("votes");
        sb.append('=');
        sb.append(((this.votes == null)?"<null>":this.votes));
        sb.append(',');
        sb.append("watches");
        sb.append('=');
        sb.append(((this.watches == null)?"<null>":this.watches));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
