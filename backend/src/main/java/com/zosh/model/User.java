package com.zosh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String fullName;
	private String email;
	private String password;

	private String role;

	@JsonIgnore
	@OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL)
	private List<Issue> assignedIssues = new ArrayList<>();

	private int projectSize = 0;

	// ---------------------------
	//  Constructors
	// ---------------------------

	public User() {}

	public User(Long id, String fullName, String email, String password, String role, List<Issue> assignedIssues, int projectSize) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.assignedIssues = assignedIssues;
		this.projectSize = projectSize;
	}

	// ---------------------------
	//  Getters & Setters
	// ---------------------------

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Issue> getAssignedIssues() {
		return assignedIssues;
	}

	public void setAssignedIssues(List<Issue> assignedIssues) {
		this.assignedIssues = assignedIssues;
	}

	public int getProjectSize() {
		return projectSize;
	}

	public void setProjectSize(int projectSize) {
		this.projectSize = projectSize;
	}
}

