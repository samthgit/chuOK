package com.chuok.backend.exception;

/**
 * Exception thrown when a requested resource is not found in the database.
 * Used to signal 404 Not Found errors in the REST API.
 */
public class ResourceNotFoundException extends RuntimeException {
    /**
     * Constructs a new ResourceNotFoundException with the specified detail message.
     * @param message the detail message explaining the reason for the exception
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
