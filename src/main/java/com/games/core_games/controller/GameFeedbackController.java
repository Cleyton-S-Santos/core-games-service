package com.games.core_games.controller;

import com.games.core_games.entities.gameFeedback.GameFeedbackResponseDTO;
import com.games.core_games.entities.gameFeedback.GameFeedbackResponseWithCount;
import com.games.core_games.service.GameFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class GameFeedbackController {
    private final GameFeedbackService gameFeedbackService;

    @Autowired
    GameFeedbackController(GameFeedbackService gameFeedbackService){
        this.gameFeedbackService = gameFeedbackService;
    }

    @GetMapping("/game/{gameId}")
    GameFeedbackResponseWithCount listFeedbackByGame(@PathVariable Long gameId){
        return this.gameFeedbackService.getGameFeedback(gameId);
    }
}
