package com.chuok.backend.repository;

import com.chuok.backend.model.World;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for CRUD operations on World entities.
 * Extends JpaRepository to provide standard data access methods.
 */
@Repository
public interface WorldRepository extends JpaRepository<World, Long> {
}
