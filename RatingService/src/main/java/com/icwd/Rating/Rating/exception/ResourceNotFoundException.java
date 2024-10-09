package com.icwd.Rating.Rating.exception;


public class ResourceNotFoundException extends RuntimeException {

    ResourceNotFoundException(){
        super("Resource not found!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }


}
