package com.chuok.backend.payload;

import lombok.Getter;
import lombok.Setter;

/**
 * Payload for user registration requests.
 * Contains the username, email, and password for new user sign-up.
 */
@Getter
@Setter
public class RegisterRequest {
    /** The desired username for registration. */
    private String username;
    /** The user's email address. */
    private String email;
    /** The user's password. */
    private String password;
}
