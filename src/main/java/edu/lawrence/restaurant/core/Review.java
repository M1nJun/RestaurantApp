package edu.lawrence.restaurant.core;

public class Review {
	private String restaurantId;
	private String userId;
	private String posted;
	private int quality;
	private int ambiance;
	private int price;
	private String comment;
	
	public String getRestaurantId() {
		return restaurantId;
	}
	
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getPosted() {
		return posted;
	}
	
	public void setPosted(String posted) {
		this.posted = posted;
	}
	
	public int getQuality() {
		return quality;
	}
	
	public void setQuality(int quality) {
		this.quality = quality;
	}
	
	public int getAmbiance() {
		return ambiance;
	}
	
	public void setAmbiance(int ambiance) {
		this.ambiance = ambiance;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}

