package com.zosh.request;

public class CreateMessageRequest {

	private Long senderId;
	private Long projectId;
	private String content;

	// -------------------------
	// No-args Constructor
	// -------------------------
	public CreateMessageRequest() {
	}

	// -------------------------
	// All-args Constructor
	// -------------------------
	public CreateMessageRequest(Long senderId, Long projectId, String content) {
		this.senderId = senderId;
		this.projectId = projectId;
		this.content = content;
	}

	// -------------------------
	// Getters & Setters
	// -------------------------

	public Long getSenderId() {
		return senderId;
	}

	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
