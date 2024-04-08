package com.restapi.EventsFinderRestAPI.Exception;

@SuppressWarnings("serial")
public class DatabaseOperationException extends RuntimeException {
	public DatabaseOperationException(String message) {
        super(message);
    }
}
