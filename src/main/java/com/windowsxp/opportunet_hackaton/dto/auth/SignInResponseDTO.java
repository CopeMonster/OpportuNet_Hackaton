package com.windowsxp.opportunet_hackaton.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInResponseDTO {
    private String token;
    private String message;

    public static SignInResponseDTO from(String token, String message) {
        return SignInResponseDTO.builder()
                .token(token)
                .message("Login successful!")
                .build();
    }
}
