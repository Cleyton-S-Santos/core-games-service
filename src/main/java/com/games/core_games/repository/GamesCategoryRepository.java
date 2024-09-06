package com.games.core_games.repository;

import com.games.core_games.entities.gamesCategory.GamesCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository()
public interface GamesCategoryRepository extends JpaRepository<GamesCategoryEntity, Long> {
    Optional<GamesCategoryEntity> findByGameCategoryName(String name);
    List<GamesCategoryEntity> findByGameCategoryNameContaining(String name);
}
