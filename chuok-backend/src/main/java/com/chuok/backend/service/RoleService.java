package com.chuok.backend.service;

import com.chuok.backend.model.Role;
import com.chuok.backend.repository.RoleRepository;
import org.springframework.stereotype.Service;
import com.chuok.backend.exception.ResourceNotFoundException;

import java.util.List;

/**
 * Service class for managing Role entities.
 * Provides methods for CRUD operations on roles.
 */
@Service
public class RoleService {
    /** Repository for accessing Role data. */
    private final RoleRepository roleRepository;

    /**
     * Constructor for dependency injection.
     * @param roleRepository the RoleRepository instance
     */
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    /**
     * Retrieves all roles from the database.
     * @return list of all roles
     */
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    /**
     * Retrieves a single role by its ID.
     * @param id the role ID
     * @return the Role if found
     * @throws ResourceNotFoundException if not found
     */
    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id " + id));
    }

    /**
     * Creates a new role in the database.
     * @param role the Role to create
     * @return the saved Role
     */
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    /**
     * Updates an existing role by ID.
     * @param id the role ID
     * @param updated the updated Role data
     * @return the updated Role
     */
    public Role updateRole(Long id, Role updated) {
        Role existing = getRoleById(id);
        existing.setName(updated.getName());
        return roleRepository.save(existing);
    }

    /**
     * Deletes a role by its ID.
     * @param id the role ID
     */
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
