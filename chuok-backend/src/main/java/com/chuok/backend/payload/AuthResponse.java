package com.chuok.backend.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Payload for authentication responses.
 * Contains the JWT token returned after successful authentication.
 */
@Getter
@AllArgsConstructor
public class AuthResponse {
    /** The JWT token for the authenticated user. */
    private String token;
}
