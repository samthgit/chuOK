package com.chuok.backend.repository;

import com.chuok.backend.model.World;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorldRepository extends JpaRepository<World, Long> {
}
