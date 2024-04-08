package com.restapi.EventsFinderRestAPI.Exception;

@SuppressWarnings("serial")
public class InvalidInputException extends RuntimeException{
	public InvalidInputException(String message) {
        super(message);
    }
}
