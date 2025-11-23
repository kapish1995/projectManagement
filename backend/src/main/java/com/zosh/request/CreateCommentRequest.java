package com.zosh.request;

public class CreateCommentRequest {

    private Long issueId;
    private String content;

    // Constructor (No-args)
    public CreateCommentRequest() {
    }

    // Constructor (All-args)
    public CreateCommentRequest(Long issueId, String content) {
        this.issueId = issueId;
        this.content = content;
    }

    // Getters & Setters
    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


