package com.game.tennis;

public enum MatchStatus {

    IN_PROGRESS("in progress"), WINNER_ONE("Player1 wins"), WINNER_TWO("Player2 wins");
    private String status;

    MatchStatus(String status) {
        this.status = status;
    }
}
