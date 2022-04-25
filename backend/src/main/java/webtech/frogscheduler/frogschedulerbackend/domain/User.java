package webtech.frogscheduler.frogschedulerbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
    private String password;
    private boolean enabled;
    private String roles;
    private String phone;
    private String firstname;
    private String lastname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assignedTo")
    @JsonIgnore
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

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
