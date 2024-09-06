package com.games.core_games.entities.gamesEntity;

import com.games.core_games.entities.gamesCategory.GamesCategoryEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity()
@Table(name = "TB_GAMES")
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GamesEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "game_name")
    private String gameName;

    @Column(name = "game_image")
    private String gameImage;

    @ManyToOne
    @JoinColumn(name = "game_main_category", referencedColumnName = "game_category_id")
    private GamesCategoryEntity gameMainCategory;

    @ManyToOne
    @JoinColumn(name = "game_secondary_category", referencedColumnName = "game_category_id")
    private GamesCategoryEntity gameSecondaryCategory;

    @Column(name = "game_rating")
    private int gameRating;
}
