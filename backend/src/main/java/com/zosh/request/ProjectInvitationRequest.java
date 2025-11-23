package com.zosh.request;

public class ProjectInvitationRequest {

    private Long projectId;
    private String email;

    // -------------------------
    // No-args Constructor
    // -------------------------
    public ProjectInvitationRequest() {
    }

    // -------------------------
    // All-args Constructor
    // -------------------------
    public ProjectInvitationRequest(Long projectId, String email) {
        this.projectId = projectId;
        this.email = email;
    }

    // -------------------------
    // Getters & Setters
    // -------------------------

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
