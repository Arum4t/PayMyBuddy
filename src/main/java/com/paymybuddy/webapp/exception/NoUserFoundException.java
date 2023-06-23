package com.paymybuddy.webapp.exception;

public class NoUserFoundException extends Exception {

    private final String email;

    public NoUserFoundException(String email) {
        super("No user found for this specific email");
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
