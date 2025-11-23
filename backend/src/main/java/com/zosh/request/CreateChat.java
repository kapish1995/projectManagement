package com.zosh.request;

import java.util.List;

public class CreateChat {

	private Long projectId;
	private List<Long> userIds;

	// -------------------------
	// No-args Constructor
	// -------------------------
	public CreateChat() {
	}

	// -------------------------
	// All-args Constructor
	// -------------------------
	public CreateChat(Long projectId, List<Long> userIds) {
		this.projectId = projectId;
		this.userIds = userIds;
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

	public List<Long> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Long> userIds) {
		this.userIds = userIds;
	}
}
