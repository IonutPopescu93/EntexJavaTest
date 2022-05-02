package com.entex.user.controller.exception;

public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException(String detailMessage) {
        super(detailMessage);
    }

}
