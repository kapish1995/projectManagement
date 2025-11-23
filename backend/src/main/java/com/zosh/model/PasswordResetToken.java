package com.zosh.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class PasswordResetToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String token;

	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private User user;

	private Date expiryDate;

	// -------------------------
	// No-args Constructor
	// -------------------------
	public PasswordResetToken() {
	}

	// -------------------------
	// Required-args Constructor (token, user, expiryDate)
	// -------------------------
	public PasswordResetToken(String token, User user, Date expiryDate) {
		this.token = token;
		this.user = user;
		this.expiryDate = expiryDate;
	}

	// -------------------------
	// All-args Constructor
	// -------------------------
	public PasswordResetToken(Integer id, String token, User user, Date expiryDate) {
		this.id = id;
		this.token = token;
		this.user = user;
		this.expiryDate = expiryDate;
	}

	// -------------------------
	// Getters & Setters
	// -------------------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	// -------------------------
	// EXTRA METHOD
	// -------------------------
	public boolean isExpired() {
		return expiryDate.before(new Date());
	}
}
