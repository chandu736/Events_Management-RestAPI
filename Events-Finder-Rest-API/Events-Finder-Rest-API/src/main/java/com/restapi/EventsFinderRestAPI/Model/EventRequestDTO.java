package com.restapi.EventsFinderRestAPI.Model;

import java.time.LocalDate;

public class EventRequestDTO {
	private Double userLatitude;
	private Double userLongitude;
	private LocalDate date;
	public Double getUserLatitude() {
		return userLatitude;
	}
	public void setUserLatitude(Double userLatitude) {
		this.userLatitude = userLatitude;
	}
	public Double getUserLongitude() {
		return userLongitude;
	}
	public void setUserLongitude(Double userLongitude) {
		this.userLongitude = userLongitude;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
