package com.zosh.model;

public class RestaurantDto {

	private String title;
	private String imageUrl;
	private String description;
	private Long id;

	// -------------------------
	// No-args constructor
	// -------------------------
	public RestaurantDto() {
	}

	// -------------------------
	// All-args constructor
	// -------------------------
	public RestaurantDto(String title, String imageUrl, String description, Long id) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.description = description;
		this.id = id;
	}

	// -------------------------
	// Getters & Setters
	// -------------------------

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
