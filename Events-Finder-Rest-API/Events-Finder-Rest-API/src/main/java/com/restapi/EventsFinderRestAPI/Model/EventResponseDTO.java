package com.restapi.EventsFinderRestAPI.Model;

import java.time.LocalDate;

public class EventResponseDTO {
	private String eventName;
	private String cityName;
	private LocalDate date;
	private String weather;
	private Double distance;
	
	public EventResponseDTO() {
		
	}
	public EventResponseDTO(String eventName, String cityName, LocalDate date, String weather, Double distance) {
		this.eventName = eventName;
		this.cityName = cityName;
		this.date = date;
		this.weather = weather;
		this.distance = distance;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather; 
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "EventResponseDTO [eventName=" + eventName + ", cityName=" + cityName + ", date=" + date + ", weather="
				+ weather + ", distance=" + distance + "]";
	}
	
}
