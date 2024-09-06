package com.games.core_games.entities.gamesCategory;

import lombok.*;

@Getter @Setter
@AllArgsConstructor()
@NoArgsConstructor()
@Builder()
public class GamesCategoryResponseDTO {
    private Long gameCategoryId;
    private String gameCategoryName;
}
