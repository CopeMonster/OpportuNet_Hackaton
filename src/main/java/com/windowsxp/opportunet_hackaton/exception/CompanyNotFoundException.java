package com.windowsxp.opportunet_hackaton.exception;

public class CompanyNotFoundException extends RuntimeException {
    private final String message;

    public CompanyNotFoundException() {
        message = "Company not found";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
