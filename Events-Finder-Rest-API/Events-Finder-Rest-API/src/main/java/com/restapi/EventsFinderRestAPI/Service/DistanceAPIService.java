package com.restapi.EventsFinderRestAPI.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DistanceAPIService {

    private static final String DISTANCE_API_URL = "https://gg-backend-assignment.azurewebsites.net/api/Distance";
    private static final String DISTANCE_API_KEY = "IAKvV2EvJa6Z6dEIUqqd7yGAu7IZ8gaH-a0QO6btjRc1AzFu8Y3IcQ==";

    public double calculateDistance(double userLatitude, double userLongitude, double eventLat, double eventLon) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = DISTANCE_API_URL + "?Code=" + DISTANCE_API_KEY + "&latitude1=" + userLatitude + "&longitude1="
                + userLongitude + "&latitude2=" + eventLat + "&longitude2=" + eventLon;
        
        // Make the request and get the response as a JSON object
        Double distance = restTemplate.getForObject(apiUrl, DistanceResponse.class).getDistance();
        
        // If distance is null, handle appropriately
        if (distance == null) {
            throw new RuntimeException("Distance API returned null");
        }

        return distance;
    }

    // Define a class to represent the response from the API
    private static class DistanceResponse {
        private Double distance;

        public Double getDistance() {
            return distance;
        }

        @SuppressWarnings("unused")
		public void setDistance(Double distance) {
            this.distance = distance;
        }
    }
}
