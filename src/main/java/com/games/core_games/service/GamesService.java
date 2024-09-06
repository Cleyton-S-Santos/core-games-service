package com.games.core_games.service;

import com.games.core_games.entities.gamesCategory.GamesCategoryEntity;
import com.games.core_games.entities.gamesEntity.GameCreateRequestDTO;
import com.games.core_games.entities.gamesEntity.GameResponseDTO;
import com.games.core_games.entities.gamesEntity.GamesEntity;
import com.games.core_games.exceptions.customExceptions.GameException;
import com.games.core_games.repository.GameRepository;
import com.games.core_games.repository.GamesCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamesService {
    private final GameRepository gameRepository;
    private final GamesCategoryRepository gamesCategoryRepository;

    @Autowired
    GamesService(GameRepository gameRepository, GamesCategoryRepository gamesCategoryRepository) {
        this.gameRepository = gameRepository;
        this.gamesCategoryRepository = gamesCategoryRepository;
    }

    public List<GameResponseDTO> listAll(){
        List<GamesEntity> games = this.gameRepository.findAll();
        if(games.isEmpty()){
            throw new GameException("No games saved", HttpStatus.NOT_FOUND.value());
        }
        return games.stream()
                .map(entity -> new GameResponseDTO(entity.getGameId(),
                        entity.getGameName(),
                        entity.getGameImage(),
                        entity.getGameMainCategory(),
                        entity.getGameSecondaryCategory(),
                        entity.getGameRating()))
                .toList();
    }

    public GameResponseDTO createGame(GameCreateRequestDTO gameCreateRequestDTO) {
        GamesEntity gameEntity = null;
        if(gameCreateRequestDTO.getGameMainCategory() == null){
            throw new GameException("Game main category is required", HttpStatus.BAD_REQUEST.value());
        }
        Optional<GamesCategoryEntity> mainGameCategoryEntity = this.gamesCategoryRepository.findById(gameCreateRequestDTO.getGameMainCategory());
        if(mainGameCategoryEntity.isEmpty()){
            throw new GameException("Game main category not foud in database", HttpStatus.BAD_REQUEST.value());
        }

        if(gameCreateRequestDTO.getGameSecondaryCategory() != null){
            Optional<GamesCategoryEntity> secondaryGameCategoryEntity = this.gamesCategoryRepository.findById(gameCreateRequestDTO.getGameSecondaryCategory());
            if(secondaryGameCategoryEntity.isEmpty()){
                throw new GameException("Game secondary category not foud in database", HttpStatus.BAD_REQUEST.value());
            }
            gameEntity = this.gameRepository.save(GamesEntity.builder()
                    .gameName(gameCreateRequestDTO.getGameName())
                    .gameImage(gameCreateRequestDTO.getGameImage())
                    .gameMainCategory(mainGameCategoryEntity.get())
                    .gameSecondaryCategory(secondaryGameCategoryEntity.get())
                    .build());
        } else {
            gameEntity = this.gameRepository.save(GamesEntity.builder()
                    .gameName(gameCreateRequestDTO.getGameName())
                    .gameImage(gameCreateRequestDTO.getGameImage())
                    .gameMainCategory(mainGameCategoryEntity.get())
                    .build());
        }

        return GameResponseDTO.builder()
                .gameName(gameEntity.getGameName())
                .gameImage(gameEntity.getGameImage())
                .gameMainCategory(gameEntity.getGameMainCategory())
                .gameSecondaryCategory(gameEntity.getGameSecondaryCategory())
                .gameId(gameEntity.getGameId())
                .build();
    }
}
