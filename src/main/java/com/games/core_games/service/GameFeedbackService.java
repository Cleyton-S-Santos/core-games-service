package com.games.core_games.service;

import com.games.core_games.entities.UserEntity;
import com.games.core_games.entities.gameFeedback.GameFeedbackRequestDTO;
import com.games.core_games.entities.gameFeedback.GameFeedbackResponseDTO;
import com.games.core_games.entities.gameFeedback.GameFeedbackResponseWithCount;
import com.games.core_games.entities.gameFeedback.GamesFeedBackEntity;
import com.games.core_games.entities.gamesEntity.GamesEntity;
import com.games.core_games.exceptions.customExceptions.GameException;
import com.games.core_games.repository.GameFeedbackRepository;
import com.games.core_games.repository.GameRepository;
import com.games.core_games.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service()
public class GameFeedbackService {
    private final GameFeedbackRepository gameFeedbackRepository;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    @Autowired
    GameFeedbackService(GameFeedbackRepository gameFeedbackRepository, UserRepository userRepository, GameRepository gameRepository){
        this.gameFeedbackRepository = gameFeedbackRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
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

    public GameFeedbackResponseDTO createFeedback(GameFeedbackRequestDTO dto){
        UserEntity user = this.userRepository.findById(dto.getUserid())
                .orElseThrow(() -> new GameException("User not foud", HttpStatus.NOT_FOUND.value()));
        GamesEntity game = this.gameRepository.findById(dto.getGameId())
                .orElseThrow(() -> new GameException("Game not foud", HttpStatus.NOT_FOUND.value()));

        GamesFeedBackEntity gameFeedback = GamesFeedBackEntity.builder()
                .userOrigin(user)
                .game(game)
                .feedback(dto.getFeedback())
                .gameFeedbackScore(dto.getGameFeedbackScore())
                .build();
        GamesFeedBackEntity gameFeedbackSaved = this.gameFeedbackRepository.save(gameFeedback);
        return GameFeedbackResponseDTO.builder()
                .userOrigin(gameFeedbackSaved.getUserOrigin())
                .game(gameFeedbackSaved.getGame())
                .feedback(gameFeedbackSaved.getFeedback())
                .gameFeedbackScore(gameFeedbackSaved.getGameFeedbackScore())
                .build();
    }
}
