package aiss.GitMiner.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.util.List;

@Entity
@Table(name = "issues")
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    @NotEmpty(message = "Issue title is required")
    private String title;

    @Column(name = "description")
    @NotNull(message = "Issue description cannot be null")
    private String description;

    @Column(name = "state")
    @NotNull(message = "Issue state cannot be null")
    private String state;

    @Column(name = "createdAt")
    private String createdAt;

    @Column(name = "updatedAt")
    private String updatedAt;

    @Column(name = "closedAt")
    private String closedAt;

    @ElementCollection
    @CollectionTable(name = "issueLabels", joinColumns = @JoinColumn(name = "issueId"))
    @Column(name = "labels")
    private List<String> labels;

    @Column(name = "votes")
    private Integer votes;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorId")
    private User author;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assigneeId")
    private User assignee;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "issueId")
    private List<Comment> comments;

    public Issue() {}

    public Issue(String title, String description, String state, String createdAt, String updatedAt, String closedAt, List<String> labels, Integer votes, User author, User assignee, List<Comment> comments) {
        this.title = title;
        this.description = description;
        this.state = state;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.closedAt = closedAt;
        this.labels = labels;
        this.votes = votes;
        this.author = author;
        this.assignee = assignee;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(String closedAt) {
        this.closedAt = closedAt;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
