package com.windowsxp.opportunet_hackaton.exception;

public class NotFoundException extends RuntimeException {
    private final String message;

    public NotFoundException() {
        message = "Not found";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
