package com.spring.crud.mongodb.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Object id) {
        super( "Id : " +id+ " ID Not Found ");
    }
}
