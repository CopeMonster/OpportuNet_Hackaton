package com.windowsxp.opportunet_hackaton.dto.auth.student;

import com.windowsxp.opportunet_hackaton.entities.Student;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentSignUPResponseDTO {
    private Long userId;
    private String email;
    private String fullName;
    private String message;

    public static StudentSignUPResponseDTO from(Student student) {
        return StudentSignUPResponseDTO.builder()
                .userId(student.getId())
                .email(student.getEmail())
                .fullName(student.getFullName())
                .message("Student registered successfully!")
                .build();
    }
}
