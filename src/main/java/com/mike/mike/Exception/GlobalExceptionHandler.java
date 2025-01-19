package com.mike.mike.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    //Handle all Custom Base Exceptions
    @ExceptionHandler(CustomBaseException.class)
    public ResponseEntity<SimpleResponse> handleCustomExceptions(CustomBaseException exception) {
        return ResponseEntity.status(exception.getStatus()).body(exception.getSimpleResponse());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<SimpleResponse> handleGeneralExceptions(Exception exception){
        SimpleResponse response = new SimpleResponse("Something went wrong. Please try again.");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

}
