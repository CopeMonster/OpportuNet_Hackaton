package com.windowsxp.opportunet_hackaton.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentSignUPResponseDTO {
    private Long userId;
    private String email;
    private String fullName;
    private String message;
}
