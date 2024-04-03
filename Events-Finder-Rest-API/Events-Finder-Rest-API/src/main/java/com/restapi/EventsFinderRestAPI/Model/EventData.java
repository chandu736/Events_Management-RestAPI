package com.restapi.EventsFinderRestAPI.Model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "events_data")
@Immutable
public class EventData {
	@Id
    @Column(name = "id")
    private Long id;
	@Column(name = "evenetName")
	private String eventName;
	@Column(name = "cityName")
	private String cityName;
	@Column(name = "date")
	private LocalDate date;
	@Column(name = "time")
	private LocalTime time;
	@Column(name = "latitude")
	private Double latitude;
	@Column(name = "longitude")
	private Double longitude;
	public EventData() {
		
	}
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
