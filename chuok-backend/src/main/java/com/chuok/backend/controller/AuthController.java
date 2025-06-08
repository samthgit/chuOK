package com.chuok.backend.controller;

import com.chuok.backend.payload.*;
import com.chuok.backend.service.AuthService;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for user authentication (login and registration).
 * Provides endpoints for login and registration requests.
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    /** Service for authentication business logic. */
    private final AuthService authService;

    /**
     * Constructor for dependency injection.
     * @param authService the AuthService instance
     */
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * POST /api/auth/login - Authenticate a user and return a JWT token.
     * @param request the login request
     * @return AuthResponse containing the JWT token
     */
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }

    /**
     * POST /api/auth/register - Register a new user and return a JWT token.
     * @param request the registration request
     * @return AuthResponse containing the JWT token
     */
    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }
}
