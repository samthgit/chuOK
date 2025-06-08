package com.chuok.backend.repository;

import com.chuok.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for CRUD operations on User entities.
 * Extends JpaRepository and adds methods to check existence and find users by email.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Checks if a user exists by email.
     * @param email the user's email
     * @return true if a user with the given email exists, false otherwise
     */
    boolean existsByEmail(String email);

    /**
     * Finds a user by email.
     * @param email the user's email
     * @return an Optional containing the User if found, or empty otherwise
     */
    Optional<User> findByEmail(String email);
}
