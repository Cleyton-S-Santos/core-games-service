package com.games.core_games.service;

import com.games.core_games.entities.gamesCategory.GamesCategoryEntity;
import com.games.core_games.entities.gamesCategory.GamesCategoryRequestDTO;
import com.games.core_games.entities.gamesCategory.GamesCategoryResponseDTO;
import com.games.core_games.exceptions.customExceptions.GameCategoryException;
import com.games.core_games.repository.GamesCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service()
public class GamesCategoryService {
    private final GamesCategoryRepository gamesCategoryRepository;
    @Autowired
    GamesCategoryService(GamesCategoryRepository gamesCategoryRepository) {
        this.gamesCategoryRepository = gamesCategoryRepository;
    };

    public GamesCategoryResponseDTO createCategory(GamesCategoryRequestDTO gamesCategoryRequestDTO){
        Optional<GamesCategoryEntity> gameCategoryAlreadyInDatabase = gamesCategoryRepository.findByGameCategoryName(gamesCategoryRequestDTO.getGameCategoryName());
        if(gameCategoryAlreadyInDatabase.isPresent()){
            throw new GameCategoryException("Category already exists", HttpStatus.CONFLICT.value());
        }
        GamesCategoryEntity gamesCategoryEntity = GamesCategoryEntity.builder()
                .gameCategoryName(gamesCategoryRequestDTO.getGameCategoryName())
                .build();
        GamesCategoryEntity created = this.gamesCategoryRepository.save(gamesCategoryEntity);
        return GamesCategoryResponseDTO.builder()
                .gameCategoryName(created.getGameCategoryName())
                .gameCategoryId(created.getGameCategoryId())
                .build();
    }

    public List<GamesCategoryResponseDTO> searchGameCategory(String gameCategoryInput){
        List<GamesCategoryEntity> categoryFound = this.gamesCategoryRepository.findByGameCategoryNameContaining(gameCategoryInput);
        if(categoryFound.isEmpty()){
            throw new GameCategoryException("Category Not Found", HttpStatus.NOT_FOUND.value());
        }
        return categoryFound.stream()
                .map(entity -> new GamesCategoryResponseDTO(entity.getGameCategoryId(), entity.getGameCategoryName()))
                .toList();
    }

    public List<GamesCategoryResponseDTO> listAll(){
        List<GamesCategoryEntity> categoryFound = this.gamesCategoryRepository.findAll();
        if(categoryFound.isEmpty()){
            throw new GameCategoryException("Categories not foud, create one!", HttpStatus.NOT_FOUND.value());
        }
        return categoryFound.stream()
                .map(entity -> new GamesCategoryResponseDTO(entity.getGameCategoryId(), entity.getGameCategoryName()))
                .toList();
    }
}
