package com.mike.mike.Exception;

import org.springframework.http.HttpStatus;

public class ResourceNotValid extends CustomBaseException{
    public ResourceNotValid(String resourceName) {
        super(HttpStatus.BAD_REQUEST, new SimpleResponse(resourceName + " Not Valid", HttpStatus.BAD_REQUEST.toString()));
    }
}
