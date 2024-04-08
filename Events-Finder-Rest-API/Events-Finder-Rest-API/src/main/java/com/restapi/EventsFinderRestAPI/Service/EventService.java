package com.restapi.EventsFinderRestAPI.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restapi.EventsFinderRestAPI.Exception.ResourceNotFoundException;
import com.restapi.EventsFinderRestAPI.Model.EventData;
import com.restapi.EventsFinderRestAPI.Model.EventResponseDTO;
import com.restapi.EventsFinderRestAPI.Model.PaginatedEventResponseDTO;
import com.restapi.EventsFinderRestAPI.Repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
    private EventRepository eventRepository;
    
    @Autowired
    private DistanceAPIService distanceAPIService;
    
    @Autowired
    private WeatherAPIService weatherAPIService;
    
    public PaginatedEventResponseDTO getEventsWithWeatherAndDistance(double latitude, double longitude, LocalDate startDate, int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        
        List<EventData> events = eventRepository.getEvents(latitude, longitude, startDate, offset, pageSize);
        
        if (events.isEmpty()) {
            throw new ResourceNotFoundException("No events found.");
        }
        
        List<EventResponseDTO> responseDTO = new ArrayList<>();
        
        for (EventData event : events) {
            double distance = distanceAPIService.calculateDistance(latitude, longitude, event.getLatitude(), event.getLongitude());
            String weather = weatherAPIService.getWeatherInfo(event.getCityName(), event.getDate());
            EventResponseDTO response = new EventResponseDTO();
            response.setEventName(event.getEventName());
            response.setCityName(event.getCityName());
            response.setDate(event.getDate());
            response.setWeather(weather);
            response.setDistance(distance);
            responseDTO.add(response);
        }
        
        int totalEvents = eventRepository.getTotalEvents(latitude, longitude, startDate);
        int totalPages = totalEvents / pageSize + (totalEvents % pageSize == 0 ? 0 : 1);
        int actualPageSize = events.size() < pageSize && page == totalPages ? events.size() : pageSize;
        
        PaginatedEventResponseDTO paginatedResponse = new PaginatedEventResponseDTO();
        paginatedResponse.setEvents(responseDTO);
        paginatedResponse.setPage(page);
        paginatedResponse.setPageSize(actualPageSize);
        paginatedResponse.setTotalPages(totalPages);
        paginatedResponse.setTotalEvents(totalEvents);
        
        return paginatedResponse;
    }
    
    public int getTotalEventsCount(double latitude, double longitude, LocalDate startDate) {
        return eventRepository.getTotalEvents(latitude, longitude, startDate);
    }
}
