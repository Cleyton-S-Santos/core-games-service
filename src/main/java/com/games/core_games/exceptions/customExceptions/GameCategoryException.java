package com.games.core_games.exceptions.customExceptions;

public class GameCategoryException extends RuntimeException {
    private final int status;

    public GameCategoryException(String message, int status) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return super.getMessage();
    }
}
