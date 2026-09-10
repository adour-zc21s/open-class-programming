package com.adour.openclassprog.service.impl;

import com.adour.openclassprog.enums.TokenType;
import com.adour.openclassprog.model.User;
import com.adour.openclassprog.payload.req.AuthenticationRequest;
import com.adour.openclassprog.payload.req.RegisterRequest;
import com.adour.openclassprog.payload.res.AuthenticationResponse;
import com.adour.openclassprog.repository.UserRepository;
import com.adour.openclassprog.service.AuthenticationService;
import com.adour.openclassprog.service.JwtService;
import com.adour.openclassprog.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 11/06/2026 - 19:22
 */
@Service @Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenService refreshTokenService;
    private final LocalStorageService localStorageService;
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        user = userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(user.getId());

        var roles = user.getRole().getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::getAuthority)
                .toList();

        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .email(user.getEmail())
                .username(user.getUsername())
                .id(user.getId())
                .refreshToken(refreshToken.getToken())
                .roles(roles)
                .tokenType( TokenType.BEARER.name())
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // 1. Jalankan autentikasi Spring Security (memakai identifier & password)
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getIdentifier(),
                        request.getPassword()
                )
        );

        // 2. Ambil data user dari DB
        var user = userRepository.findByEmailOrUsername(request.getIdentifier(), request.getIdentifier())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email/username or password."));
        var roles = user.getRole().getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::getAuthority)
                .toList();
        var jwt = jwtService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(user.getId());
        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .roles(roles)
                .email(user.getEmail())
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .id(user.getId())
                .refreshToken(refreshToken.getToken())
                .tokenType( TokenType.BEARER.name())
                .profileImageUrl(user.getProfileImageUrl())
                .build();
    }
    @Override
    @Transactional
    public void updateProfileImage(Long userId, String newFileName) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        // Delete the previous profile image if it exists to avoid orphaned files
        if (user.getProfileImageUrl() != null) {
            localStorageService.deleteFile(user.getProfileImageUrl());
        }

        user.setProfileImageUrl(newFileName);
        userRepository.save(user);
    }
}
