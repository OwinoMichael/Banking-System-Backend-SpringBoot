package com.mike.mike.SuccessResponse;

public class SuccessResponse {

    private String message;
    private Object object;

    public SuccessResponse(String message, Object object) {
        this.message = message;
        this.object = object;
    }

    public SuccessResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
