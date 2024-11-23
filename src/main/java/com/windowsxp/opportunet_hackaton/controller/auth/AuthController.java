package com.windowsxp.opportunet_hackaton.controller.auth;

import com.windowsxp.opportunet_hackaton.dto.*;
import com.windowsxp.opportunet_hackaton.service.auth.SignInService;
import com.windowsxp.opportunet_hackaton.service.auth.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final SignUpService signUpService;
    private final SignInService signInService;

    @PostMapping("/sign-up/student")
    public ResponseEntity<StudentSignUPResponseDTO> studentSignUp(@Valid @RequestBody StudentSignUPRequestDTO dto) {
        StudentSignUPResponseDTO studentSignUPResponseDTO = signUpService.registerStudent(dto);
        return ResponseEntity.ok(studentSignUPResponseDTO);
    }

    @PostMapping("/sign-up/company")
    public ResponseEntity<CompanySignUPResponseDTO> companySighUp(@Valid @RequestBody CompanySignUPRequestDTO dto) {
        CompanySignUPResponseDTO companySignUPResponseDTO = signUpService.registerCompany(dto);
        return ResponseEntity.ok(companySignUPResponseDTO);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<SignInResponseDTO> signIn(@Valid @RequestBody SignInRequestDTO dto) {
        SignInResponseDTO signInResponseDTO = signInService.login(dto);
        return ResponseEntity.ok(signInResponseDTO);
    }
}
