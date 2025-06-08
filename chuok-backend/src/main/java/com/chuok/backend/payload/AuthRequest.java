package com.chuok.backend.payload;

import lombok.Getter;
import lombok.Setter;

/**
 * Payload for authentication requests.
 * Contains the user's email and password for login.
 */
@Getter
@Setter
public class AuthRequest {
    /** The user's email address. */
    private String email;
    /** The user's password. */
    private String password;
}
