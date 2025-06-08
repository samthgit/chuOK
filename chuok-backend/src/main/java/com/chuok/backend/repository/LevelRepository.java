package com.chuok.backend.repository;

import com.chuok.backend.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for CRUD operations on Level entities.
 * Extends JpaRepository and adds a method to find levels by world ID.
 */
@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
    /**
     * Finds all levels belonging to a specific world by its ID.
     * @param worldId the ID of the world
     * @return list of levels in the given world
     */
    List<Level> findByWorld_Id(Long worldId);
}
