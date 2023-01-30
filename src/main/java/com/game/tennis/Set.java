package com.game.tennis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Set {
    private static final Integer ONE = 1;
    private static final Integer SIX = 6;
    private Player playerOne;
    private Player playerTwo;
    private String status;
    private Player winner;
    private Game currentGame;

    public Set(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void play(){
            currentGame = new Game(playerOne, playerTwo);
            currentGame.play();
            incrementSetScorePlayer();
    }

    private void incrementSetScorePlayer() {
        Integer setScoreDifference = Math.abs(playerOne.getGameScore() - playerTwo.getGameScore());

        // CASE OF A TIEBREAK
        if(playerOne.getGameScore() == SIX && setScoreDifference == 0){
            this.status = "TieBreak";
        } // THE LAST SET WAS TIEBREAK AND A PLAYER SCORES NOW
        else if("TieBreak".equals(this.getStatus()) && setScoreDifference == 1 ){
            this.status = "Won";
            this.winner = this.getHighestSetScorePlayer();
            this.winner.setSetScore(this.winner.getSetScore() +1 );

        } // ONE OF THE PLAYERS HAS REACHED 6 GAMES AND HAS WON AT LEAST TWO GAMES THAN THE OPPONENT
        else if(setScoreDifference > ONE && (playerOne.getGameScore() >= SIX || playerTwo.getGameScore() >=SIX)){
            this.status = "Won";
            this.winner = this.getHighestSetScorePlayer();
            this.winner.setSetScore(this.winner.getSetScore() +1 );
        } else if(setScoreDifference >= ONE && (playerOne.getGameScore() >= SIX && playerTwo.getGameScore() >=SIX)){
            this.winner = this.getHighestSetScorePlayer();
            this.winner.setSetScore(this.winner.getSetScore() +1 );
        }
    }

    private Player getHighestSetScorePlayer() {
        return playerOne.getGameScore() > playerTwo.getGameScore() ? playerOne : playerTwo;
    }

}
