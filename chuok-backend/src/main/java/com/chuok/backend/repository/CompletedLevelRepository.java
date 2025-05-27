package com.chuok.backend.repository;

import com.chuok.backend.model.CompletedLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedLevelRepository extends JpaRepository<CompletedLevel, Long> {
}
