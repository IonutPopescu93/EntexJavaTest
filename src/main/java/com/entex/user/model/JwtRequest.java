package com.entex.user.model;

public class JwtRequest {

    private String username;
    private String password;

    public JwtRequest() {
    }

    public JwtRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public JwtRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public JwtRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
