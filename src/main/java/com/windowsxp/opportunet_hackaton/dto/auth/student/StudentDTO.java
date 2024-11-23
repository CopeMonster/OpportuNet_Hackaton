package com.windowsxp.opportunet_hackaton.dto.auth.student;

import com.windowsxp.opportunet_hackaton.entities.Student;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class StudentDTO {
    private String fullName;
    private String email;
    private String phoneNumber;
    private String aboutMe;
    private List<String> skills;
    private String portfolio;

    public static StudentDTO from(Student student) {
        return StudentDTO.builder()
                .fullName(student.getFullName())
                .email(student.getEmail())
                .phoneNumber(student.getPhoneNumber())
                .aboutMe(student.getAboutMe())
                .skills(student.getSkills())
                .portfolio(student.getPortfolio())
                .build();
    }
}
