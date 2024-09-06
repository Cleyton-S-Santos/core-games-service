package com.games.core_games.entities.gameFeedback;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GameFeedbackRequestDTO {
    @NotNull(message = "Game feedback score cannot be null.")
    @Max(value = 50, message = "Game feedback score must not be greater than 50.")
    private Long gameFeedbackScore;

    @NotNull(message = "User ID cannot be null.")
    private Long userid;

    @NotNull(message = "Game ID cannot be null.")
    private Long gameId;

    private String feedback;
}
