package com.games.core_games.entities.gameFeedback;

import com.games.core_games.entities.UserEntity;
import com.games.core_games.entities.gamesEntity.GamesEntity;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameFeedbackResponseDTO {
    private Long feedBackId;
    private Long gameFeedbackScore;
    private UserEntity userOrigin;
    private GamesEntity game;
    private String feedback;
    private int totalFeedback;
}
