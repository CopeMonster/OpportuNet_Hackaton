package com.windowsxp.opportunet_hackaton.dto.auth.company;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanySignUPRequestDTO {
    @NotBlank(message = "Company name is required")
    private String name;

    @NotBlank(message = "BIN is required")
    @Pattern(regexp = "^[0-9]{12}$", message = "BIN must be 12 digits")
    private String BIN;

    @NotBlank(message = "Contact email is required")
    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
}
