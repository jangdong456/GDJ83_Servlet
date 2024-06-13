package com.jang.home.weather;

public class WeatherDTO {
	
	private long num;
	private String city;
	private double gion;
	private String status;
	private int huminity;
	
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public double getGion() {
		return gion;
	}
	public void setGion(double gion) {
		this.gion = gion;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getHuminity() {
		return huminity;
	}
	public void setHuminity(int huminity) {
		this.huminity = huminity;
	}
	
	
	
}
