package com.games.core_games.repository;

import com.games.core_games.entities.gameFeedback.GamesFeedBackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository()
public interface GameFeedbackRepository extends JpaRepository<GamesFeedBackEntity, Long> {
    @Query(value = "SELECT tbf FROM GamesFeedBackEntity tbf WHERE tbf.game.gameId = :gameId",
    countQuery = "SELECT count(tbf) FROM GamesFeedBackEntity tbf WHERE tbf.game.gameId = :gameId")
    Optional<List<GamesFeedBackEntity>> findFeedbackByGameId(@Param("gameId") Long gameId);
}
