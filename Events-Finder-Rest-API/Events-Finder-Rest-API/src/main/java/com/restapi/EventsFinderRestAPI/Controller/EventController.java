package com.restapi.EventsFinderRestAPI.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.EventsFinderRestAPI.Model.EventRequestDTO;
import com.restapi.EventsFinderRestAPI.Model.EventResponseDTO;
import com.restapi.EventsFinderRestAPI.Service.EventService;

@RestController
@RequestMapping("/")
public class EventController {
	@Autowired
	private EventService eventService;
	
	@GetMapping("events/find")
	public List<EventResponseDTO> findEvents(EventRequestDTO request){
		List<EventResponseDTO> events=eventService.findEvents(request.getUserLatitude(),request.getUserLongitude(),request.getDate());
		return events;
	}
}
