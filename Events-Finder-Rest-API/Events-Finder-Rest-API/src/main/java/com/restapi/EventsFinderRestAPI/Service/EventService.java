package com.restapi.EventsFinderRestAPI.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.EventsFinderRestAPI.Model.EventData;
import com.restapi.EventsFinderRestAPI.Model.EventResponseDTO;
import com.restapi.EventsFinderRestAPI.Repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private DistanceAPIService distanceAPIService;
	
	@Autowired
	private WeatherAPIService weatherAPIService;
	
	public List<EventResponseDTO> findEvents(Double userLatitude,Double userLongitude,LocalDate startDate){
		LocalDate endDate=startDate.plusDays(14);
		List<EventData> events=eventRepository.findByDateBetween(startDate, endDate);
		List<EventResponseDTO> eventDTOs=new ArrayList<>();
		for(EventData event:events) {
			Double distance=distanceAPIService.calculateDistance(userLatitude, userLongitude, event.getLatitude(), event.getLongitude());
			String weather=weatherAPIService.getWeatherInfo(event.getCityName(),event.getDate());
			EventResponseDTO eventDTO=new EventResponseDTO(event.getEventName(),event.getCityName(),event.getDate(),weather,distance);
			eventDTOs.add(eventDTO);
		}
		return eventDTOs;
	}
}
