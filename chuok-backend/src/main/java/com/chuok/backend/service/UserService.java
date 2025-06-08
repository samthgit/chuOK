package com.chuok.backend.service;

import com.chuok.backend.model.User;
import com.chuok.backend.repository.UserRepository;
import com.chuok.backend.model.Role;
import com.chuok.backend.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing User entities.
 * Provides methods for CRUD operations on users.
 */
@Service
public class UserService {
    /** Repository for accessing User data. */
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    /**
     * Constructor for dependency injection.
     * @param userRepository the UserRepository instance
     */
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    /**
     * Retrieves all users from the database.
     * @return list of all users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Retrieves a single user by their ID.
     * @param id the user ID
     * @return the User if found
     * @throws RuntimeException if not found
     */
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    /**
     * Creates a new user in the database.
     * @param user the User to create
     * @return the saved User
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Updates an existing user by ID.
     * @param id the user ID
     * @param updatedUser the updated User data
     * @return the updated User
     */
    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        return userRepository.save(existingUser);
    }

    /**
     * Deletes a user by their ID.
     * @param id the user ID
     */
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUserRole(Long userId, Long roleId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Role newRole = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        user.setRole(newRole);
        return userRepository.save(user);
    }
}
