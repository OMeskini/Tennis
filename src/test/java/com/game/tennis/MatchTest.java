package com.game.tennis;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatchTest {

    private Player playerOne;
    private Player playerTwo;

    @Before
    public void setupPlayers() {
        playerOne = new Player("Oumaima");
        playerTwo = new Player("David");
    }

    @Test
    public void playerOneShouldWinTheMatch(){
        //GIVEN
        Match match = new Match(playerOne, playerTwo);
        Set currentSet = new Set(playerOne, playerTwo);
        playerOne.setGameScore(6);
        playerTwo.setGameScore(1);
        match.setCurrentSet(currentSet);
        match.play();
        playerOne.setGameScore(7);
        playerTwo.setGameScore(5);
        match.setCurrentSet(currentSet);
        match.play();
        playerOne.setGameScore(6);
        playerTwo.setGameScore(0);
        match.setCurrentSet(currentSet);
        // WHEN
        match.play();

        // THEN
        String expectedStatus ="(6-1) (7-5) (6-0) ";
        assertEquals(expectedStatus, match.getScore());
        assertEquals(MatchStatus.WINNER_ONE, match.getStatus());
    }

    @Test
    public void secondPlayerShouldWin(){
        // GIVEN
        Player playerOne = new Player("Oumaima");
        Player playerTwo = new Player("David");
        Match match = new Match(playerOne, playerTwo);
        Set currentSet = new Set(playerOne, playerTwo);
        playerOne.setGameScore(6);
        playerTwo.setGameScore(1);
        match.setCurrentSet(currentSet);
        match.play();
        playerOne.setGameScore(7);
        playerTwo.setGameScore(5);
        match.setCurrentSet(currentSet);
        match.play();
        playerOne.setGameScore(2);
        playerTwo.setGameScore(6);
        match.setCurrentSet(currentSet);
        match.play();
        playerOne.setGameScore(6);
        playerTwo.setGameScore(7);
        match.setCurrentSet(currentSet);
        match.play();
        playerOne.setGameScore(4);
        playerTwo.setGameScore(6);
        match.setCurrentSet(currentSet);
        // WHEN
        match.play();
        // THEN
        String expectedStatus ="(6-1) (7-5) (2-6) (6-7) (4-6) ";
        assertEquals(expectedStatus, match.getScore());
        assertEquals(MatchStatus.WINNER_TWO, match.getStatus());
    }
}
