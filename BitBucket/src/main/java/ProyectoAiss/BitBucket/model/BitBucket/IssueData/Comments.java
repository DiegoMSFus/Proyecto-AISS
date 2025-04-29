
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
    "created_on",
    "updated_on",
    "content",
    "user",
    "issue",
    "links"
})

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comments {

    @JsonProperty("type")
    public String type;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("created_on")
    public String createdOn;
    @JsonProperty("updated_on")
    public Object updatedOn;
    @JsonProperty("content")
    public Content content;
    @JsonProperty("user")
    public User user;
    @JsonProperty("issue")
    public IssueData issue;
    @JsonProperty("links")
    public Links links;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Comments.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("type");
        sb.append('=');
        sb.append(((this.type == null)?"<null>":this.type));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("createdOn");
        sb.append('=');
        sb.append(((this.createdOn == null)?"<null>":this.createdOn));
        sb.append(',');
        sb.append("updatedOn");
        sb.append('=');
        sb.append(((this.updatedOn == null)?"<null>":this.updatedOn));
        sb.append(',');
        sb.append("content");
        sb.append('=');
        sb.append(((this.content == null)?"<null>":this.content));
        sb.append(',');
        sb.append("user");
        sb.append('=');
        sb.append(((this.user == null)?"<null>":this.user));
        sb.append(',');
        sb.append("issue");
        sb.append('=');
        sb.append(((this.issue == null)?"<null>":this.issue));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
