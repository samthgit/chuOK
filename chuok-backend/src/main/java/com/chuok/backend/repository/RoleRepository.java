package com.chuok.backend.repository;

import com.chuok.backend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for CRUD operations on Role entities.
 * Extends JpaRepository and adds a method to find a role by name.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * Finds a role by its name.
     * @param name the name of the role
     * @return an Optional containing the Role if found, or empty otherwise
     */
    Optional<Role> findByName(String name);
}
