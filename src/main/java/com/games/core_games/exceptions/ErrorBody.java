package com.games.core_games.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorBody {
    private String message;
    private int status;

    public ErrorBody(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
