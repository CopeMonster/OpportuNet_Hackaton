package com.windowsxp.opportunet_hackaton.dto.company;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanySignUPResponseDTO {
    private Long userId;
    private String email;
    private String name;
    private String message;
}
