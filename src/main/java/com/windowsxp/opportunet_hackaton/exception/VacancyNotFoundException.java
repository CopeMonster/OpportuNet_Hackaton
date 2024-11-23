package com.windowsxp.opportunet_hackaton.exception;

public class VacancyNotFoundException extends RuntimeException {
    private final String message;

    public VacancyNotFoundException() {
        message = "Vacancy not found";
    }

    @Override
    public String getMessage() {
        return message;
    }
}
