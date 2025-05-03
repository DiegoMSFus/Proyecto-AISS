package aiss.GitMiner.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

@Entity
@Table(name = "commits")
public class Commit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    @NotEmpty(message = "Commit title is required")
    private String title;

    @Column(name = "message")
    private String message;

    @Column(name = "authorName")
    @NotNull(message = "Author name cannot be null")
    private String authorName;

    @Column(name = "authorEmail")
    @Email(message = "Author email must be an acceptable email")
    private String authorEmail;

    @Column(name = "authoredDate")
    private String authoredDate;

    @Column(name = "webUrl")
    private String webUrl;

    public Commit() {}

    public Commit(String title, String message, String authorName, String authorEmail, String authoredDate, String webUrl) {
        this.title = title;
        this.message = message;
        this.authorName = authorName;
        this.authorEmail = authorEmail;
        this.authoredDate = authoredDate;
        this.webUrl = webUrl;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public String getAuthoredDate() {
        return authoredDate;
    }

    public void setAuthoredDate(String authoredDate) {
        this.authoredDate = authoredDate;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}