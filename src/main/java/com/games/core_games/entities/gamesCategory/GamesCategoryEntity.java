package com.games.core_games.entities.gamesCategory;

import jakarta.persistence.*;
import lombok.*;

@Entity()
@Getter @Setter
@Table(name = "TB_GAMES_CATEGORY")
@Builder()
@AllArgsConstructor()
@NoArgsConstructor()
public class GamesCategoryEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_category_id")
    private Long gameCategoryId;

    @Column(name = "game_category_name")
    private String gameCategoryName;
}
