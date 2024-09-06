package com.games.core_games.entities.gameFeedback;

import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameFeedbackResponseWithCount {
    private List<GameFeedbackResponseDTO> gameFeedbackResponseDTOList;
    private int gameFeedbackResponseCount;
}
