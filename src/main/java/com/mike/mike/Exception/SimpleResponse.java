package com.mike.mike.Exception;

public class SimpleResponse {
    private String message;
    private String errorCode;
    private String timeStamp;

    public SimpleResponse(String message) {
        this.message = message;
        this.timeStamp = java.time.Instant.now().toString();
    }

    public SimpleResponse(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
        this.timeStamp = java.time.Instant.now().toString();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
