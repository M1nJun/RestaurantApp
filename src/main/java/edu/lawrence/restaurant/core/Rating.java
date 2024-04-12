package edu.lawrence.restaurant.core;

public class Rating {
	private String restaurantID;
	private int avg_quality;
	private int avg_ambiance;
	private int avg_price;
	private int count;
	
	public String getRestaurantID() {
		return restaurantID;
	}
	
	public void setRestaurantID(String restaurantID) {
		this.restaurantID = restaurantID;
	}
	
	public int getAvgQuality() {
		return avg_quality;
	}
	
	public void setAvgQuality(int avg_quality) {
		this.avg_quality = avg_quality;
	}
	
	public int getAvgAmbiance() {
		return avg_ambiance;
	}
	
	public void setAvgAmbiance(int avg_ambiance) {
		this.avg_ambiance = avg_ambiance;
	} 
	
	public int getAvgPrice() {
		return avg_price;
	}
	
	public void setAvgPrice(int avg_price) {
		this.avg_price = avg_price;
	} 
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
