package com.chuok.backend.controller;

import com.chuok.backend.model.Role;
import com.chuok.backend.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing Role entities.
 * Provides endpoints for CRUD operations on Role resources.
 */
@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RoleController {
    /** Service for handling Role business logic. */
    private final RoleService roleService;

    /**
     * Constructs a RoleController with the given RoleService.
     * @param roleService the service to handle Role operations
     */
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    /**
     * Retrieves a list of all roles.
     * @return list of Role entities
     */
    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    /**
     * Retrieves a role by its ID.
     * @param id the ID of the role
     * @return the Role entity with the given ID
     */
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id) {
        return roleService.getRoleById(id);
    }

    /**
     * Creates a new role.
     * @param role the Role entity to create
     * @return the created Role entity
     */
    @PostMapping
    public Role createRole(@Valid @RequestBody Role role) {
        return roleService.createRole(role);
    }

    /**
     * Updates an existing role by ID.
     * @param id the ID of the role to update
     * @param updated the updated Role entity
     * @return the updated Role entity
     */
    @PutMapping("/{id}")
    public Role updateRole(@PathVariable Long id, @Valid @RequestBody Role updated) {
        return roleService.updateRole(id, updated);
    }

    /**
     * Deletes a role by its ID.
     * @param id the ID of the role to delete
     */
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }
}
