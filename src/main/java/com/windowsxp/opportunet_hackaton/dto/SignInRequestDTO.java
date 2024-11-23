package com.windowsxp.opportunet_hackaton.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInRequestDTO {
    private String email;
    private String password;
    private String role;
}
