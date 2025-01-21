package com.shortcut.example.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String userId) {
        super("User " + userId + " not found");
    }
}
