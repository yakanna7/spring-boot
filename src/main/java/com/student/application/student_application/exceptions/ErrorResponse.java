package com.student.application.student_application.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ErrorResponse {

    private String message;
    private ZonedDateTime dateTime;
    private HttpStatus httpStatus;
    private String path;
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public HttpStatus getResponseStatus() {
        return httpStatus;
    }

    public void setResponseStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }



    public ErrorResponse(String message, ZonedDateTime dateTime, HttpStatus httpStatus , String path) {
        this.message = message;
        this.dateTime = dateTime;
        this.httpStatus = httpStatus;
        this.path = path;
    }

    public  ErrorResponse(){

    }

}
