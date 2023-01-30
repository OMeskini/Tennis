package com.game.tennis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Match {

    private Player playerOne;
    private Player playerTwo;
    private Player winner;
    private MatchStatus status;
    private String score = "";
    private Set currentSet;

    public Match(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    void play() {
        StringBuilder stringBuilder = new StringBuilder(score);
            this.currentSet = new Set(playerOne, playerTwo);
            this.currentSet.play();
            this.score = stringBuilder.append("(").append(playerOne.getGameScore()).append("-").append(playerTwo.getGameScore()).append(") ").toString();
            //this.currentSet.getWinner().setSetScore(currentSet.getWinner().getSetScore() + 1);
            if (playerOne.getSetScore() == 3 && playerTwo.getSetScore() < 3) {
                this.winner = this.playerOne;
                this.status = MatchStatus.WINNER_ONE;
            } else if (this.playerTwo.getSetScore() == 3 && this.playerOne.getSetScore() < 3) {
                this.winner = playerTwo;
                this.status = MatchStatus.WINNER_TWO;
            } else {
                this.status = MatchStatus.IN_PROGRESS;
            }
    }
}
