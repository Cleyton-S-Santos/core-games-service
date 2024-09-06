package com.games.core_games.entities.gamesEntity;

import com.games.core_games.entities.gamesCategory.GamesCategoryEntity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GameCreateRequestDTO {
    private String gameName;
    private String gameImage;
    private Long gameMainCategory;
    private Long gameSecondaryCategory;
}
