package com.windowsxp.opportunet_hackaton.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvalidCredentials extends RuntimeException {
    private final String message;

    public InvalidCredentials() {
        message = "Invalid email or password";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
