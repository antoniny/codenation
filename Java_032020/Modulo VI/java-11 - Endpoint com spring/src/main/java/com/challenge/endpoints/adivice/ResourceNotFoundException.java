package com.challenge.endpoints.adivice;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName) {
        super("Resoource: " + resourceName + " not found.");
    }
}
