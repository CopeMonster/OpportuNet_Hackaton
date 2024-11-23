package com.windowsxp.opportunet_hackaton.exception;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserExistException extends RuntimeException {
    private final String message;

    public UserExistException() {
        message = "User is already exist";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
