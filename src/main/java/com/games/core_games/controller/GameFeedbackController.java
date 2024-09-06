package com.games.core_games.controller;

import com.games.core_games.entities.gameFeedback.GameFeedbackRequestDTO;
import com.games.core_games.entities.gameFeedback.GameFeedbackResponseDTO;
import com.games.core_games.entities.gameFeedback.GameFeedbackResponseWithCount;
import com.games.core_games.service.GameFeedbackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/feedback")
public class GameFeedbackController {
    private final GameFeedbackService gameFeedbackService;

    @Autowired
    GameFeedbackController(GameFeedbackService gameFeedbackService){
        this.gameFeedbackService = gameFeedbackService;
    }

    @GetMapping("/game/{gameId}")
    ResponseEntity<GameFeedbackResponseWithCount> listFeedbackByGame(@PathVariable Long gameId){
        return ResponseEntity.ok(this.gameFeedbackService.getGameFeedback(gameId));
    }

    @PostMapping("/create")
    public ResponseEntity<GameFeedbackResponseDTO> saveFeedback(@Valid @RequestBody GameFeedbackRequestDTO gameFeedbackRequestDTO){
        return ResponseEntity.ok(this.gameFeedbackService.createFeedback(gameFeedbackRequestDTO));
    }
}
