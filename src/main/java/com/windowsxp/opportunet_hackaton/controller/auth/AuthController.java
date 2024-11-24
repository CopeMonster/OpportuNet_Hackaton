package com.windowsxp.opportunet_hackaton.controller.auth;

import com.windowsxp.opportunet_hackaton.dto.auth.SignInRequestDTO;
import com.windowsxp.opportunet_hackaton.dto.auth.SignInResponseDTO;
import com.windowsxp.opportunet_hackaton.dto.auth.company.CompanySignUPRequestDTO;
import com.windowsxp.opportunet_hackaton.dto.auth.company.CompanySignUPResponseDTO;
import com.windowsxp.opportunet_hackaton.dto.auth.student.StudentSignUPRequestDTO;
import com.windowsxp.opportunet_hackaton.dto.auth.student.StudentSignUPResponseDTO;
import com.windowsxp.opportunet_hackaton.security.MyUserDetails;
import com.windowsxp.opportunet_hackaton.service.auth.SignInService;
import com.windowsxp.opportunet_hackaton.service.auth.SignUpService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final SignUpService signUpService;
    private final SignInService signInService;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/sign-up/student")
    public String signUpStudentPage(Model model) {
        return "Registration_Student";
    }

    @GetMapping("/sign-up/company")
    public String signUpCompanyPage(Model model) {
        return "Registration_Company";
    }

    @GetMapping("/sign-in")
    public String signInPage(Model model) {
        return "mainunreg";
    }

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
        Authentication authentication =
                authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(
                                dto.getEmail(),
                                dto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        SignInResponseDTO signInResponseDTO = signInService.login(dto);
        return ResponseEntity.ok(signInResponseDTO);
    }
}
