package com.entex.user.model;
import javax.persistence.*;

@Entity
@Table(name = "usersData")
public class UserDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String username;
    private String locality;
    private String county;
    private String password;

    public UserDao() {
    }

    public UserDao(Long id, String email, String name, String locality, String county, String password) {
        this.id = id;
        this.email = email;
        this.username = name;
        this.locality = locality;
        this.county = county;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public UserDao setId(Long id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDao setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDao setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDao setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getLocality() {
        return locality;
    }

    public UserDao setLocality(String locality) {
        this.locality = locality;
        return this;
    }

    public String getCounty() {
        return county;
    }

    public UserDao setCounty(String county) {
        this.county = county;
        return this;
    }
}
