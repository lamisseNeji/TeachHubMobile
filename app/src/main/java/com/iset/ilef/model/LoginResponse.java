package com.iset.ilef.model;

public class LoginResponse {
    private String jwt;
    private String role;
    private Long userId;

    // Getters et setters

    public String getJwt() {
        return jwt;
    }

    public String getRole() {
        return role;
    }

    public Long getUserId() {
        return userId;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
