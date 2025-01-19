package com.mike.mike.Exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFound extends CustomBaseException{

    public ResourceNotFound(String resourceName) {
        super(HttpStatus.NOT_FOUND, new SimpleResponse(resourceName + " Not Found", HttpStatus.NOT_FOUND.toString()));
    }
}
