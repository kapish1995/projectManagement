package com.zosh.request;

public class TokenValidationRequest {

    private String token;
    private String userEmail;
    private Long projectId;

    // -------------------------
    // No-args Constructor
    // -------------------------
    public TokenValidationRequest() {
    }

    // -------------------------
    // All-args Constructor
    // -------------------------
    public TokenValidationRequest(String token, String userEmail, Long projectId) {
        this.token = token;
        this.userEmail = userEmail;
        this.projectId = projectId;
    }

    // -------------------------
    // Getters & Setters
    // -------------------------

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
