package com.iitbombay.coursesApi.exception;

public class InstanceNotFoundException extends RuntimeException{
    public InstanceNotFoundException(String message) {
        super(message);
    }
}
