package com.chuok.backend.repository;

import com.chuok.backend.model.CompletedLevel;
import com.chuok.backend.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for CRUD operations on CompletedLevel entities.
 * Extends JpaRepository and adds custom queries for user-level completion tracking.
 */
@Repository
public interface CompletedLevelRepository extends JpaRepository<CompletedLevel, Long> {
    /**
     * Checks if a completed level exists for a user and level ID.
     * @param email the user's email
     * @param levelId the level ID
     * @return true if the user has completed the level, false otherwise
     */
    @Query("SELECT COUNT(cl) > 0 FROM CompletedLevel cl WHERE cl.user.email = :email AND cl.level.id = :levelId")
    boolean existsByUserEmailAndLevelId(@Param("email") String email, @Param("levelId") Long levelId);

    /**
     * Finds all completed levels for a user by email.
     * @param email the user's email
     * @return list of completed Level entities
     */
    @Query("SELECT cl.level FROM CompletedLevel cl WHERE cl.user.email = :email")
    List<Level> findCompletedLevelsByUserEmail(@Param("email") String email);

    /**
     * Finds all CompletedLevel records for a user, ordered by completion date descending.
     * @param email the user's email
     * @return list of CompletedLevel entities
     */
    @Query("SELECT cl FROM CompletedLevel cl WHERE cl.user.email = :email ORDER BY cl.completionDate DESC")
    List<CompletedLevel> findAllByUserEmailOrderByCompletionDateDesc(@Param("email") String email);
}
