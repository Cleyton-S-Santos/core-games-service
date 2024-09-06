package com.games.core_games.exceptions.handler;

import com.games.core_games.exceptions.ErrorBody;
import com.games.core_games.exceptions.customExceptions.GameCategoryException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GameCategoryExceptionHandler {
    @ExceptionHandler(GameCategoryException.class)
    public ResponseEntity<ErrorBody> handleCustomFeignException(GameCategoryException ex) {
        ErrorBody errorResponse = new ErrorBody(ex.getMessage(), ex.getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.valueOf(ex.getStatus()));
    }
}
