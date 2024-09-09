package com.games.core_games.entities.gamesEntity;

import com.games.core_games.entities.gamesCategory.GamesCategoryEntity;
import lombok.*;

@Getter @Setter
@Builder()
@AllArgsConstructor()
@NoArgsConstructor
public class GameResponseDTO {
    private Long gameId;
    private String gameName;
    private String gameImage;
    private GamesCategoryEntity gameMainCategory;
    private GamesCategoryEntity gameSecondaryCategory;
    private int game_score;
}
