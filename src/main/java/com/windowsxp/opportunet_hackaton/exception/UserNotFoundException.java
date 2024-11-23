package com.windowsxp.opportunet_hackaton.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserNotFoundException extends RuntimeException {
    private final String message;

    public UserNotFoundException() {
        message = "User not found";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
