package aiss.GitMiner.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    @NotEmpty(message = "User username is required")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "avatarUrl")
    private String avatarUrl;

    @Column(name = "webUrl")
    private String webUrl;

    public User() {}

    public User(String username, String name, String avatarUrl, String webUrl) {
        this.username = username;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.webUrl = webUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

}
