package api.model;


import api.constant.PatternConstants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "dp_user",
        uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class User {
    private static final long serialVersionUID = -4727727495060874309L;
    @Id
    @Column(name="id", nullable = false, unique = true, length = 11)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Pattern(regexp = PatternConstants.EMAIL_PATTERN, message = "Email")
    @Column(name = "login", length = 100, nullable = false, unique = true)
    private String login;

    @Column(name = "password", length = 255, nullable = false)
    private String password;

    @Column(name = "created_at", columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Column(name = "updated_at", columnDefinition="TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @Pattern(regexp = PatternConstants.PHONE_NUMBER_PATTERN, message = "Мобильный телефон")
    @Column(name = "mobile", length = 15)
    private String mobile;

    @Pattern(regexp = PatternConstants.NAME_PATTERN, message = "Имя")
    @Column(name = "first_name", length = 255, nullable = false)
    private String first_name;

    @Pattern(regexp = PatternConstants.NAME_PATTERN, message = "Отчество")
    @Column(name = "middle_name", length = 255, nullable = false)
    private String middle_name;

    @Pattern(regexp = PatternConstants.NAME_PATTERN, message = "Фамилия")
    @Column(name = "last_name", length = 255, nullable = false)
    private String last_name;

    @Column(name = "is_blocked", nullable = false)
    private boolean blocked = false;

    @Column(name = "is_deleted", nullable = false)
    private boolean deleted = false;

    @Column(name = "salt", length = 10, nullable = false)
    private String salt;

    @ManyToMany(targetEntity = Group.class, cascade = { CascadeType.ALL })
    @JoinTable(name = "user_group",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "group_id") })
    private Set<Group> groups;


    //Important to Hibernate!
    public User() {
    }

    public User(String login, String password){
        this.setId(-1);
        this.setLogin(login);
        this.setPassword(password);
    }

    public User(String login, String password, Date created_at, Date updated_at, String mobile, String first_name, String middle_name, String last_name, boolean isBlocked, boolean isDeleted, String salt, Group group) {
        this.login = login;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.mobile = mobile;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.blocked = isBlocked;
        this.deleted = isDeleted;
        this.salt = salt;

        Set<Group> groupsSet = new HashSet<>();
        groupsSet.add(group);
        this.groups = groupsSet;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public String getMobile() {
        return mobile;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    @JsonIgnore
    public String getSalt() {
        return salt;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setBlocked(boolean is_blocked) {
        this.blocked = is_blocked;
    }

    public void setDeleted(boolean is_deleted) {
        this.deleted = is_deleted;
    }

    @JsonProperty
    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public void setGroup(Group group){
        Set<Group> GroupsSet = new HashSet<>();
        GroupsSet.add(group);
        this.groups = GroupsSet;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", mobile='" + mobile + '\'' +
                ", first_name='" + first_name + '\'' +
                ", middle_name='" + middle_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", isBlocked=" + blocked +
                ", isDeleted=" + deleted +
                ", salt='" + salt + '\'' +
                ", groupses=" + groups +
                '}';
    }
}
