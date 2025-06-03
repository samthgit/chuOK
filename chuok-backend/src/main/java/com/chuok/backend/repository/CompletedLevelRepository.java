package com.chuok.backend.repository;

import com.chuok.backend.model.CompletedLevel;
import com.chuok.backend.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompletedLevelRepository extends JpaRepository<CompletedLevel, Long> {
    @Query("SELECT COUNT(cl) > 0 FROM CompletedLevel cl WHERE cl.user.email = :email AND cl.level.id = :levelId")
    boolean existsByUserEmailAndLevelId(@Param("email") String email, @Param("levelId") Long levelId);

    @Query("SELECT cl.level FROM CompletedLevel cl WHERE cl.user.email = :email")
    List<Level> findCompletedLevelsByUserEmail(@Param("email") String email);
}
