package com.revoltstore.repository;

import com.revoltstore.models.Difficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DifficultyRepository extends JpaRepository<Difficulty, Long> { }
