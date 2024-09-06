package com.games.core_games.entities.gamesCategory;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Data
public class GamesCategoryRequestDTO {
    @NotNull(message = "Field cant be null")
    private String gameCategoryName;
}
