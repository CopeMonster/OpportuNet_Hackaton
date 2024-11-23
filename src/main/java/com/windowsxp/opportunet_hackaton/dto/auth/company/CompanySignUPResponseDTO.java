package com.windowsxp.opportunet_hackaton.dto.auth.company;

import com.windowsxp.opportunet_hackaton.entities.Company;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanySignUPResponseDTO {
    private Long userId;
    private String email;
    private String name;
    private String message;

    public static CompanySignUPResponseDTO from(Company company) {
        return CompanySignUPResponseDTO.builder()
                .userId(company.getId())
                .email(company.getEmail())
                .name(company.getName())
                .message("Company registered successfully")
                .build();
    }
}
