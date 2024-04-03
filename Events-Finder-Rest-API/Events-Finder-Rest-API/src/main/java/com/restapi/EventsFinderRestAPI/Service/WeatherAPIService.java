package com.restapi.EventsFinderRestAPI.Service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class WeatherAPIService {
	
	private static final String WEATHER_API_URL="https://gg-backend-assignment.azurewebsites.net/api/Weather";
	private static final String WEATHER_API_KEY="KfQnTWHJbg1giyB_Q9Ih3Xu3L9QOBDTuU5zwqVikZepCAzFut3rqsg==";
	
	public String getWeatherInfo(String city, LocalDate date) {
		RestTemplate restTemplate=new RestTemplate();
		String apiUrl=WEATHER_API_URL+"?Code="+WEATHER_API_KEY+"&city="+city+"&date="+date+date.toString();
		return restTemplate.getForObject(apiUrl,String.class);
	}
}
