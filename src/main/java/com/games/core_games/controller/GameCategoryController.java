package com.games.core_games.controller;

import com.games.core_games.entities.gamesCategory.GamesCategoryRequestDTO;
import com.games.core_games.entities.gamesCategory.GamesCategoryResponseDTO;
import com.games.core_games.service.GamesCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class GameCategoryController {

    private final GamesCategoryService gamesCategoryService;

    @Autowired()
    GameCategoryController(GamesCategoryService gamesCategoryService) {
        this.gamesCategoryService = gamesCategoryService;
    }

    @PostMapping("/create")
    ResponseEntity<GamesCategoryResponseDTO> createCategory(@RequestBody() GamesCategoryRequestDTO gamesCategoryRequestDTO) throws Exception {
        return ResponseEntity.ok(this.gamesCategoryService.createCategory(gamesCategoryRequestDTO));
    }

    @GetMapping("/search")
    ResponseEntity<List<GamesCategoryResponseDTO>> searchCategory(@RequestParam String input) {
        return ResponseEntity.ok(this.gamesCategoryService.searchGameCategory(input));
    }

    @GetMapping("/list")
    ResponseEntity<List<GamesCategoryResponseDTO>> listCategory() {
        return ResponseEntity.ok(this.gamesCategoryService.listAll());
    }
}
