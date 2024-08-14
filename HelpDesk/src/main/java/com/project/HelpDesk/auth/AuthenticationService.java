package com.project.HelpDesk.auth;


import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.project.HelpDesk.repository.*;
import com.project.HelpDesk.model.*;
import  com.project.HelpDesk.service.*;
import  com.project.HelpDesk.controller.*;
import  com.project.HelpDesk.auth.*;
import com.project.HelpDesk.config.*;
import lombok.Data;

@Service
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

public class AuthenticationService {

    private final userRepo repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = userModel.builder()
                .userName(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
 );
        var user = userRepo.findByUserName(request.getEmail())
                .orElseThrow();

        var jwtToken = jwtService.generateToken((UserDetails) user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
