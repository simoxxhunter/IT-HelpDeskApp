package com.project.HelpDesk.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.project.HelpDesk.repository.*;
import com.project.HelpDesk.model.*;
import  com.project.HelpDesk.service.*;
import  com.project.HelpDesk.controller.*;
import  com.project.HelpDesk.auth.*;
import com.project.HelpDesk.config.*;



@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)


public class SecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JWTauthentification jwtAuthFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("api/v1/auth/**").permitAll()
                  .requestMatchers("/tickets/**","/equipements/Admin/**","/technicians/**" )
                        .permitAll()
//                  .requestMatchers("/tickets/ADMIN/**").hasauthority.role("ADMIN")
//
//.re("/equipements/Admin/**").has("ADMIN")
                        .anyRequest()
                        .authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
