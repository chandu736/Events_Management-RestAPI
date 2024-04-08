package com.restapi.EventsFinderRestAPI.Controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.restapi.EventsFinderRestAPI.Exception.InvalidInputException;
import com.restapi.EventsFinderRestAPI.Model.PaginatedEventResponseDTO;
import com.restapi.EventsFinderRestAPI.Service.EventService;

@RestController
@RequestMapping("/events")
public class EventController {
	
	@Autowired
	private EventService eventService;
	
	@GetMapping("/find")
	public PaginatedEventResponseDTO getEvents(
	        @RequestParam double latitude,
	        @RequestParam double longitude,
	        @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
	        @RequestParam(defaultValue = "1") int page,
	        @RequestParam(defaultValue = "10") int pageSize) {
	    if (latitude < -90 || latitude > 90 || longitude < -180 || longitude > 180) {
	        throw new InvalidInputException("Latitude and longitude must be within valid ranges.");
	    }
	    
	    return eventService.getEventsWithWeatherAndDistance(latitude, longitude, startDate, page, pageSize);
	}
}
