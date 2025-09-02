package com.spring.crud.mongodb.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id) {
        super( id+ " Not deleted and Not found ");
    }
}
