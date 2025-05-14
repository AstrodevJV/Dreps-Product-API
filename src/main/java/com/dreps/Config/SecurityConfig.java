package com.dreps.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF (útil para APIs REST)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permite todos los endpoints sin autenticación
                );

        return http.build();
    }
}

