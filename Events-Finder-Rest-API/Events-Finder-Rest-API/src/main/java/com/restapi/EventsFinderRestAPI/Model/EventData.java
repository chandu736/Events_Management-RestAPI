package com.restapi.EventsFinderRestAPI.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class EventData {
	
	@Id
	private Long id;
	@JsonProperty
	private String eventName;
	@JsonProperty
	private String cityName;
	@JsonProperty
	private LocalDate date;
	@JsonProperty
	private LocalTime time;
	@JsonProperty
	private Double latitude;
	@JsonProperty
	private Double longitude;
	public EventData(String eventName, String cityName, LocalDate date, LocalTime time, Double latitude,
			Double longitude) {
		super();
		this.eventName = eventName;
		this.cityName = cityName;
		this.date = date;
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public EventData(String eventName, String cityName, LocalDate date, Double latitude, Double longitude) {
		super();
		this.eventName = eventName;
		this.cityName = cityName;
		this.date = date;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public EventData() {
		// TODO Auto-generated constructor stub
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
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "EventData [eventName=" + eventName + ", cityName=" + cityName + ", date=" + date + ", time=" + time
				+ ", latitude=" + latitude + ", longitude=" + longitude + "]";
	} 
}
