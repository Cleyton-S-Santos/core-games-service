package com.games.core_games.controller;

import com.games.core_games.entities.gamesEntity.GameResponseDTO;
import com.games.core_games.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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

//    5 seg
    @GetMapping("/list")
    ResponseEntity<List<GameResponseDTO>> findAll(){
        return ResponseEntity.ok(this.gamesService.listAll());
    }

    @GetMapping("/v2/list")
    public ResponseEntity<Page<GameResponseDTO>> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "15") int size) {
        Page<GameResponseDTO> gamePage = this.gamesService.listAllPage(page, size);
        return ResponseEntity.ok(gamePage);
    }


    @GetMapping("/{id}")
    ResponseEntity<GameResponseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.gamesService.findById(id));
    }
}
