package com.windowsxp.opportunet_hackaton.exception;

public class EmptyFileException extends RuntimeException {
    private final String message;

    public EmptyFileException() {
        message = "Empty file";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
