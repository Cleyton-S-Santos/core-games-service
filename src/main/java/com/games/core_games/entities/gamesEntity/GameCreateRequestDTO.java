package com.games.core_games.entities.gamesEntity;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GameCreateRequestDTO {
    @NotNull(message = "Field cant be null")
    private String gameName;
    private String gameImage;
    @NotNull(message = "Field cant be null")
    private Long gameMainCategory;
    private Long gameSecondaryCategory;
}
