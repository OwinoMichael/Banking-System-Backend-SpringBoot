package com.mike.mike.Exception;

import org.springframework.http.HttpStatus;

public class CustomBaseException extends RuntimeException {

    private HttpStatus httpStatus;
    private SimpleResponse simpleResponse;

    public CustomBaseException(HttpStatus status, SimpleResponse simpleResponse) {
        this.httpStatus = status;
        this.simpleResponse = simpleResponse;
    }

    public HttpStatus getStatus() {
        return httpStatus;
    }

    public void setStatus(HttpStatus status) {
        this.httpStatus = status;
    }

    public SimpleResponse getSimpleResponse() {
        return simpleResponse;
    }

    public void setSimpleResponse(SimpleResponse simpleResponse) {
        this.simpleResponse = simpleResponse;
    }
}
