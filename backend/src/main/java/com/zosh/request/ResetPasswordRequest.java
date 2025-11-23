package com.zosh.request;

public class ResetPasswordRequest {

	private String password;
	private String token;

	// -------------------------
	// No-args Constructor
	// -------------------------
	public ResetPasswordRequest() {
	}

	// -------------------------
	// All-args Constructor
	// -------------------------
	public ResetPasswordRequest(String password, String token) {
		this.password = password;
		this.token = token;
	}

	// -------------------------
	// Getters & Setters
	// -------------------------

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
