package com.mitarth.devtask.exception;
//it is my custom exception handler
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}
