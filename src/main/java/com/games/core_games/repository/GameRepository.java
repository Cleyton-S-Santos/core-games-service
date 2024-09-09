package com.games.core_games.repository;

import com.games.core_games.entities.gamesEntity.GamesEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository()
public interface GameRepository extends JpaRepository<GamesEntity, Long> {
    @Query(value = "SELECT * FROM TB_GAMES tg where tg.game_main_category = ?1 OR tg.game_secondary_category = ?1", nativeQuery = true)
    Page<GamesEntity> findGamesByCategory(Long categoryId, Pageable page);

    @Query(value = "select * from TB_GAMES tg where tg.game_name LIKE ?1%", nativeQuery = true)
    Page<GamesEntity> findGamesByName(String categoryId, Pageable page);
}
