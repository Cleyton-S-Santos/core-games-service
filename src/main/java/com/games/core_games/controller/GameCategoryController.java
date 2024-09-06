package com.games.core_games.controller;

import com.games.core_games.entities.gamesCategory.GamesCategoryRequestDTO;
import com.games.core_games.entities.gamesCategory.GamesCategoryResponseDTO;
import com.games.core_games.service.GamesCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    GamesCategoryResponseDTO createCategory(@RequestBody() GamesCategoryRequestDTO gamesCategoryRequestDTO) throws Exception {
        return this.gamesCategoryService.createCategory(gamesCategoryRequestDTO);
    }

    @GetMapping("/search")
    List<GamesCategoryResponseDTO> searchCategory(@RequestParam String input) {
        return this.gamesCategoryService.searchGameCategory(input);
    }

    @GetMapping("/list")
    List<GamesCategoryResponseDTO> listCategory() {
        return this.gamesCategoryService.listAll();
    }
}
