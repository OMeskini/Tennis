package com.game.tennis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class Game {

    private Player playerOne;
    private Player playerTwo;
    private String status;
    private Player winner;
    private static final String DEUCE = "deuce";
    private static final String ADVANTAGE = "Advantage";

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void play(){

            Integer scoreDifference = Math.abs(playerOne.getGameScore() - playerTwo.getGameScore());
            if (GamePoints.Forty.ordinal() == playerOne.getGameScore() && scoreDifference == 0
            || (ADVANTAGE.equals(this.getStatus()) && scoreDifference == 0)) {
                this.status = DEUCE;
            } else if (DEUCE.equals(this.status) && scoreDifference == 1) {
                this.status = ADVANTAGE;
            }
            else if (scoreDifference >= 2 && (GamePoints.Forty.ordinal() <= playerOne.getGameScore() ||
                    GamePoints.Forty.ordinal() <= playerTwo.getGameScore())) {
                this.status = this.calculateTheScore(playerOne.getGameScore(), playerTwo.getGameScore());
                this.winner = playerOne.getGameScore() > playerTwo.getGameScore() ? playerOne : playerTwo;
            } else if(scoreDifference >= 1 && (GamePoints.Forty.ordinal() < playerOne.getGameScore() ||
                    GamePoints.Forty.ordinal() < playerTwo.getGameScore())) {
                this.status = this.calculateTheScore(playerOne.getGameScore(), playerTwo.getGameScore());
                this.winner = playerOne.getGameScore() > playerTwo.getGameScore() ? playerOne : playerTwo;
            } else {
                this.status = this.calculateTheScore(playerOne.getGameScore(), playerTwo.getGameScore());
            }
    }

    private String calculateTheScore(Integer gameScore1, Integer gameScore2) {
        if(gameScore1 <= GamePoints.Forty.ordinal() &&  gameScore2 <= GamePoints.Forty.ordinal() ){
            return GamePoints.score(gameScore1) + "-" + GamePoints.score(gameScore2);
        }
        return gameScore1 + "-" + gameScore2;
    }


}
