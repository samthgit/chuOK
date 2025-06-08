package com.chuok.backend.service;

import com.chuok.backend.model.User;
import com.chuok.backend.repository.UserRepository;
import com.chuok.backend.security.CustomUserDetails;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

/**
 * Service class for loading user details for Spring Security authentication.
 * Implements UserDetailsService to provide user details by email.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * Constructor for dependency injection.
     * @param userRepository the UserRepository instance
     */
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Loads a user by email for authentication.
     * @param email the user's email
     * @return UserDetails for Spring Security
     * @throws UsernameNotFoundException if user is not found
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        return new CustomUserDetails(user);
    }
}