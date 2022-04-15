package com.entex.user.model;

public class JwtResponse {

    private String JwtToken;

    public JwtResponse() {
    }

    public JwtResponse(String jwtToken) {
        JwtToken = jwtToken;
    }

    public String getJwtToken() {
        return JwtToken;
    }

    public JwtResponse setJwtToken(String jwtToken) {
        JwtToken = jwtToken;
        return this;
    }
}
