package com.games.core_games.service;

import com.games.core_games.entities.gameFeedback.GameFeedbackResponseDTO;
import com.games.core_games.entities.gameFeedback.GameFeedbackResponseWithCount;
import com.games.core_games.entities.gameFeedback.GamesFeedBackEntity;
import com.games.core_games.exceptions.customExceptions.GameException;
import com.games.core_games.repository.GameFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service()
public class GameFeedbackService {
    private final GameFeedbackRepository gameFeedbackRepository;

    @Autowired
    GameFeedbackService(GameFeedbackRepository gameFeedbackRepository){
        this.gameFeedbackRepository = gameFeedbackRepository;
    }

    public GameFeedbackResponseWithCount getGameFeedback(Long gameId){
        Optional<List<GamesFeedBackEntity>> gameFeedback = this.gameFeedbackRepository.findFeedbackByGameId(gameId);
        if(gameFeedback.isEmpty()){
            throw new GameException("Feedbakcs not found to this game", HttpStatus.NOT_FOUND.value());
        }

        List<GameFeedbackResponseDTO> response = gameFeedback.get().stream().map(feedbacks -> GameFeedbackResponseDTO.builder()
                .feedback(feedbacks.getFeedback())
                .game(feedbacks.getGame())
                .feedBackId(feedbacks.getFeedBackId())
                .userOrigin(feedbacks.getUserOrigin())
                .gameFeedbackScore(feedbacks.getGameFeedbackScore())
                .totalFeedback(gameFeedback.get().size())
                .build()).toList();
        return GameFeedbackResponseWithCount.builder()
                .gameFeedbackResponseCount(gameFeedback.get().size())
                .gameFeedbackResponseDTOList(response).build();
    }
}
