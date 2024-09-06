package com.games.core_games.entities.gameFeedback;

import com.games.core_games.entities.UserEntity;
import com.games.core_games.entities.gamesEntity.GamesEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity()
@Table(name = "TB_GAMES_FEEDBACKS")
@Getter() @Setter()
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GamesFeedBackEntity {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long feedBackId;

    @Column(name = "score")
    private Long gameFeedbackScore;

    @ManyToOne
    @JoinColumn(name = "user_origin", referencedColumnName = "user_id")
    private UserEntity userOrigin;

    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "game_id")
    private GamesEntity game;

    @Column(name = "feedback")
    private String feedback;
}
