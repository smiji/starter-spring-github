package com.nac.spgit.exception;

public class ResourceMissingException extends RuntimeException {
    public ResourceMissingException() {
    }

    public ResourceMissingException(String message) {
        super(message);
    }

    public ResourceMissingException(String message, Throwable cause) {
        super(message, cause);
    }
}
