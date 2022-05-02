package com.entex.user.controller.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String detailMessage) {
        super(detailMessage);
    }

}
