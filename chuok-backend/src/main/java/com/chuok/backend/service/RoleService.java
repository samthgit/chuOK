package com.chuok.backend.service;

import com.chuok.backend.model.Role;
import com.chuok.backend.repository.RoleRepository;
import org.springframework.stereotype.Service;
import com.chuok.backend.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id " + id));
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role updateRole(Long id, Role updated) {
        Role existing = getRoleById(id);
        existing.setName(updated.getName());
        return roleRepository.save(existing);
    }

    public void deleteRole(Long id) {
        Role role = getRoleById(id);
        roleRepository.deleteById(id);
    }
}
