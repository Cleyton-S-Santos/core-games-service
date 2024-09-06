package com.games.core_games.controller;

import com.games.core_games.entities.gamesEntity.GameCreateRequestDTO;
import com.games.core_games.entities.gamesEntity.GameResponseDTO;
import com.games.core_games.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/game")
public class GameController {
    private final GamesService gamesService;

    @Autowired
    GameController(GamesService gamesService) {
        this.gamesService = gamesService;
    }

    @GetMapping("/list")
    List<GameResponseDTO> findAll(){
        return this.gamesService.listAll();
    }

    @PostMapping("/create")
    GameResponseDTO createGame(@RequestBody()GameCreateRequestDTO gameCreateRequestDTO){
        return this.gamesService.createGame(gameCreateRequestDTO);
    }
}
