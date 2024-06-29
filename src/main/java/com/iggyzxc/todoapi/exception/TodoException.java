package com.iggyzxc.todoapi.exception;

public class TodoException extends RuntimeException {

    public TodoException(String message) {
        super(message);
    }

    public static class IdNotFoundException extends TodoException {
        public IdNotFoundException(String message) {
            super(message);
        }
    }

    public static class ResourceNotFoundException extends TodoException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }

}
