package com.windowsxp.opportunet_hackaton.dto.auth;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInResponseDTO {
    private String token;
    private String message;
}
