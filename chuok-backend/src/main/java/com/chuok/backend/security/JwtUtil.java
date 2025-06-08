package com.chuok.backend.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * Utility class for generating, validating, and extracting information from JWT tokens.
 * Handles secret key initialization, token creation, username extraction, and validation.
 */
@Component
public class JwtUtil {

    /** The secret key used for signing JWT tokens (injected from properties). */
    @Value("${jwt.secret}")
    private String secret;

    /** The expiration time for JWT tokens in milliseconds (injected from properties). */
    @Value("${jwt.expiration}")
    private long expiration;

    /** The cryptographic secret key for signing JWT tokens. */
    private SecretKey secretKey;

    /**
     * Initializes the secret key after the bean is constructed.
     */
    @PostConstruct
    public void init() {
        // Inicializa la clave una vez al cargar el bean
        this.secretKey = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Generates a JWT token for the given username.
     * @param username the username to include in the token
     * @return the generated JWT token
     */
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * Extracts the username from a JWT token.
     * @param token the JWT token
     * @return the username contained in the token
     */
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * Validates the given JWT token for integrity and expiration.
     * @param token the JWT token to validate
     * @return true if the token is valid, false otherwise
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
