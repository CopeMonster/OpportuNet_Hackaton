package com.windowsxp.opportunet_hackaton.service.auth;

import com.windowsxp.opportunet_hackaton.dto.auth.company.CompanySignUPRequestDTO;
import com.windowsxp.opportunet_hackaton.dto.auth.company.CompanySignUPResponseDTO;
import com.windowsxp.opportunet_hackaton.dto.auth.student.StudentSignUPRequestDTO;
import com.windowsxp.opportunet_hackaton.dto.auth.student.StudentSignUPResponseDTO;
import com.windowsxp.opportunet_hackaton.entities.Company;
import com.windowsxp.opportunet_hackaton.entities.Student;
import com.windowsxp.opportunet_hackaton.entities.enums.Role;
import com.windowsxp.opportunet_hackaton.exception.UserExistException;
import com.windowsxp.opportunet_hackaton.repositories.CompanyRepository;
import com.windowsxp.opportunet_hackaton.repositories.StudentRepository;
import com.windowsxp.opportunet_hackaton.repositories.UserRepository;
import com.windowsxp.opportunet_hackaton.utils.JwtTokenProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public StudentSignUPResponseDTO registerStudent(@Valid StudentSignUPRequestDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new UserExistException("Email is already in use");
        }

        Student student = Student.builder()
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(Role.STUDENT)
                .fullName(dto.getFullName())
                .phoneNumber(dto.getPhoneNumber())
                .build();

        studentRepository.save(student);

        return StudentSignUPResponseDTO.builder()
                .userId(student.getId())
                .email(student.getEmail())
                .fullName(student.getFullName())
                .message("Student registered successfully!")
                .build();
    }

    public CompanySignUPResponseDTO registerCompany(@Valid CompanySignUPRequestDTO dto) {
        if (userRepository.existsByEmail(dto.getContactEmail())) {
            throw new UserExistException("Email is already in use");
        }

        Company company = Company.builder()
                .email(dto.getContactEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(Role.COMPANY)
                .name(dto.getName())
                .BIN(dto.getBIN())
                .build();
        companyRepository.save(company);

        return CompanySignUPResponseDTO.builder()
                .userId(company.getId())
                .email(company.getEmail())
                .name(company.getName())
                .message("Company registered successfully")
                .build();
    }
}
