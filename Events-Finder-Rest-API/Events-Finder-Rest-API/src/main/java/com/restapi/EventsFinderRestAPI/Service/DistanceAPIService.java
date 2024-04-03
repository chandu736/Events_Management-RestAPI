package com.restapi.EventsFinderRestAPI.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class DistanceAPIService {
	
	private static final String DISTANCE_API_URL="https://gg-backend-assignment.azurewebsites.net/api/Distance";
	private static final String DISTANCE_API_KEY="IAKvV2EvJa6Z6dEIUqqd7yGAu7IZ8gaH-a0QO6btjRc1AzFu8Y3IcQ==";
	
	public double calculateDistance(double userLat, double userLon, double eventLat, double eventLon) {
		RestTemplate restTemplate=new RestTemplate();
		String apiUrl=DISTANCE_API_URL+"?Code="+DISTANCE_API_KEY+"&latitude1="+userLat+"&longitude1="+userLon+"&latitude2="+eventLat+"&longitude2="+eventLon;
		return restTemplate.getForObject(apiUrl,Double.class); 
	}
}
