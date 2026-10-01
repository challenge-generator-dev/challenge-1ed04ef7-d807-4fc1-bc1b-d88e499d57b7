package com.ecommerce.service;

import com.ecommerce.dto.JwtRequest;
import com.ecommerce.dto.JwtResponse;
import com.ecommerce.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public JwtResponse login(JwtRequest request) {
        throw new UnsupportedOperationException("Implementar autenticación JWT");
    }

    public JwtResponse register(JwtRequest request) {
        throw new UnsupportedOperationException("Implementar registro de usuario");
    }

    public boolean validateToken(String token) {
        throw new UnsupportedOperationException("Implementar validación de token");
    }

    public String getUsernameFromToken(String token) {
        throw new UnsupportedOperationException("Implementar extracción de usuario del token");
    }
}