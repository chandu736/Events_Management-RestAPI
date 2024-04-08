# Events-FInder-RestAPI

## Overview

This project is a RESTful service for finding and managing events data based on a user's geographical location and specified date. It is built using Java Spring Boot and MySQL, with API testing conducted through Postman.

## Tech Stack and Database

### Tech Stack:
- **Spring Boot:** Used for building and deploying Java applications quickly and easily. It provides a wide range of features out of the box, including embedded Tomcat server and auto-configuration.
- **Spring Web:** Provides essential web functionalities such as handling HTTP requests. It enables building RESTful APIs and web applications.
- **Spring JDBC Template:** Used for database access and manipulation when more control over SQL queries is needed.
- **MySQL:** Chosen as the database management system for its reliability, performance, and ease of integration with Spring Boot.

### Database:
- **MySQL:** Chosen for its widespread adoption, robustness, and compatibility with Spring Boot.

## Design Decisions and Challenges

- **Choice of Tech Stack:** Spring Boot was chosen for its rapid development capabilities and easy configuration. MySQL was chosen for its reliability and compatibility with Spring Boot.
- **Database Schema Design:** The database schema was designed to efficiently store and retrieve event data based on location and date. Tables were normalized to reduce redundancy and improve data integrity.
- **Handling Pagination:** Pagination was implemented to efficiently handle large datasets by fetching only a subset of data at a time. This improves application performance and user experience. Pagination parameter that is page number accepted as query parameter in API requests.
- **Error Handling:** Proper error handling mechanisms were implemented throughout the application to provide meaningful error messages to users. Custom exception classes were created to handle specific error scenarios, such as invalid input and resource not found.

## Setup and Run Instructions

### Prerequisites:
- Java JDK (22)
- Maven (version 4.0.0)
- MySQL (8.0.36)
- Eclipse IDE

### Steps to Setup:
1. Clone this repository: `git clone https://github.com/chandu736/Events_Management-RestAPI.git`
2. Open Eclipse IDE.
3. Click on `File` -> `Import`.
4. Select `Existing Maven Projects`.
5. Browse to the directory where you cloned the repository and select the project.
6. Click `Finish` to import the project into Eclipse.

### Run Instructions:
1. Right-click on the project in the `Package Explorer`.
2. Select `Run As` -> `Spring Boot App`.
3. The application will start running, and you can access the API endpoints as described below.

## API Endpoints

- **GET /events/find:** Retrieves events based on latitude, longitude, start date and page number.
  Example: `GET /events/find?latitude=40.7128&longitude=-74.0060&startDate=2024-04-10&page=1`

## API Testing with Postman

API testing was performed using Postman to ensure the correctness and reliability of the endpoints. A collection of API requests along with sample request payloads and expected responses is available for reference.

### API Response Format:
The API response is in JSON format and has the following structure:
```json
{
    "events": [
        {
            "eventName": "Structure support choice",
            "cityName": "Fryland",
            "date": "2024-03-15",
            "weather": "Rainy 25C",
            "distance": 8910.23984708894
        },
        {
            "eventName": "Party development available",
            "cityName": "Port Alexander",
            "date": "2024-03-15",
            "weather": "Windy 27C",
            "distance": 12710.135679967512
        },
        {
            "eventName": "Air quickly home",
            "cityName": "Lawrenceview",
            "date": "2024-03-16",
            "weather": "Sunny 12C",
            "distance": 12674.554608508966
        },
        {
            "eventName": "Of ask open",
            "cityName": "New Andrew",
            "date": "2024-03-16",
            "weather": "Rainy 3C",
            "distance": 15346.670405594576
        },
        {
            "eventName": "Create success",
            "cityName": "New Susanmouth",
            "date": "2024-03-16",
            "weather": "Sunny 5C",
            "distance": 8301.79106015074
        },
        {
            "eventName": "Phone city",
            "cityName": "Riveraberg",
            "date": "2024-03-16",
            "weather": "Rainy 16C",
            "distance": 16078.589189816212
        },
        {
            "eventName": "Glass although",
            "cityName": "Kathleenfort",
            "date": "2024-03-17",
            "weather": "Windy 1C",
            "distance": 10573.065389972637
        },
        {
            "eventName": "Political check five",
            "cityName": "Lake Timothymouth",
            "date": "2024-03-17",
            "weather": "Snowy 12C",
            "distance": 14210.540682330571
        },
        {
            "eventName": "Democrat seat nor",
            "cityName": "South Mark",
            "date": "2024-03-18",
            "weather": "Rainy 32C",
            "distance": 13743.41782006343
        },
        {
            "eventName": "Assume by",
            "cityName": "East Brandyfort",
            "date": "2024-03-18",
            "weather": "Rainy -1C",
            "distance": 16561.73323786461
        }
    ],
    "page": 1,
    "pageSize": 10,
    "totalEvents": 44,
    "totalPages": 5
}
