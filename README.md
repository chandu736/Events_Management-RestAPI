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
