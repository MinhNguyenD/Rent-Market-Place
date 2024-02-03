package com.mlproject.quickLease.exception;

public class LocationNotFound extends RuntimeException{
    public LocationNotFound(String message) {
        super(message);
    }

    public LocationNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public LocationNotFound(Throwable cause) {
        super(cause);
    }
}
