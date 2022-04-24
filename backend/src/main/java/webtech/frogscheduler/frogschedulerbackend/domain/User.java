package webtech.frogscheduler.frogschedulerbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private boolean enabled;
    private String roles;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assignedTo")
    private List<Request> appearences = new ArrayList<>();

    public User(){
    }

    public List<Request> getAppearences() {
        return appearences;
    }

    public void setAppearences(List<Request> appearences) {
        this.appearences = appearences;
    }

    public void addAppearence(Request request) {
        request.setAssignedTo(this);
        this.appearences.add(request);
    }

    public void removeAppearence(Request request) {
        request.setAssignedTo(null);
        this.appearences.remove(request);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
