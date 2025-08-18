package com.sazid.resumerover.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Disable CSRF, as we will use stateless JWT authentication
                .csrf(AbstractHttpConfigurer::disable)
                // 2. Define authorization rules
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/status").permitAll() // Allow public access to the status endpoint
                        .anyRequest().authenticated() // Secure all other requests
                );

        return http.build();
    }
}