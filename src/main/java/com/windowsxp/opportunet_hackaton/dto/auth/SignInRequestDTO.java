package com.windowsxp.opportunet_hackaton.dto.auth;

import com.windowsxp.opportunet_hackaton.entities.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInRequestDTO {
    private String email;
    private String password;
}
