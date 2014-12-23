package com.example.controllers.business.http;

/**
 * Created by user on 2014.09.21..
 */
public class LoginResponse {

    private String statusCode;

    private String message;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
