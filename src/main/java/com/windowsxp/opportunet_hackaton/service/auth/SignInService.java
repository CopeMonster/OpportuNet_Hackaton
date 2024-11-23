package com.windowsxp.opportunet_hackaton.service.auth;

import com.windowsxp.opportunet_hackaton.dto.SignInRequestDTO;
import com.windowsxp.opportunet_hackaton.dto.SignInResponseDTO;
import com.windowsxp.opportunet_hackaton.entities.User;
import com.windowsxp.opportunet_hackaton.exception.InvalidCredentials;
import com.windowsxp.opportunet_hackaton.exception.UserNotFoundException;
import com.windowsxp.opportunet_hackaton.repositories.UserRepository;
import com.windowsxp.opportunet_hackaton.utils.JwtTokenProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public SignInResponseDTO login(@Valid SignInRequestDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail()).orElseThrow(UserNotFoundException::new);

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new InvalidCredentials();
        }

        String token = jwtTokenProvider.generateToken(user);

        return SignInResponseDTO.builder()
                .token(token)
                .message("Login successful!")
                .build();
    }
}
