package com.game.tennis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SetTest {
    private static final String PLAYER_ONE_NAME = "Oumaima";
    private static final String PLAYER_TWO_NAME = "David";

    @Test
    public void itShouldBeATieDie(){
        // GVEN
        Player playerOne = new Player(PLAYER_ONE_NAME, 6, 0, 0);
        Player playerTwo = new Player(PLAYER_TWO_NAME, 6, 0, 0);

        Set set = new Set(playerOne, playerTwo);
        // WHEN
        set.play();
        // THEN
        assertEquals("TieBreak", set.getStatus());
    }

    @Test
    public void playerShouldWinAfterATieDie(){
        // GIVEN
        Player playerOne = new Player(PLAYER_ONE_NAME, 6, 0, 0);
        Player playerTwo = new Player(PLAYER_TWO_NAME, 6, 0, 0);
        Set set = new Set(playerOne, playerTwo, "TieBreak", null, null);

        playerOne.setGameScore(7);
        // WHEN
        set.play();
        // THEN
        assertEquals("Won", set.getStatus());
        assertEquals(playerOne, set.getWinner());
    }

    @Test
    public void scoreShouldBeIncremented(){
        // GIVEN
        Player playerOne = new Player(PLAYER_ONE_NAME, 5, 0, 0);
        Player playerTwo = new Player(PLAYER_TWO_NAME, 6, 0, 0);
        Set set = new Set(playerOne, playerTwo);
        set.setWinner(playerOne);
        playerOne.setGameScore(7);
        // WHEN
        set.play();
        // THEN
        assertEquals(playerOne, set.getWinner());
    }
}
