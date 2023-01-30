package com.game.tennis;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void playerOneShouldScoresFirst(){
        // GIVEN
        Player playerOne = new Player("Oumaima", 1, 0, 0);
        Player playerTwo = new Player("David", 0, 0, 0);

        Game game = new Game(playerOne, playerTwo );
        // WHEN
        game.play();
        // THEN
        assertEquals("15-0", game.getStatus());

    }

    @Test
    public void playerOneShouldScoresAgain(){
        //GIVEN
        Player playerOne = new Player("Oumaima", 2, 0, 0);
        Player playerTwo = new Player("David", 0, 0, 0);

        Game game = new Game(playerOne, playerTwo );
        // WHEN
        game.play();
        // THEN
        assertEquals("30-0", game.getStatus());

    }

    @Test
    public void gameScoreShouldBeDeuce(){
        // GIVEN
        Player playerOne = new Player("Oumaima", 3, 0, 0);
        Player playerTwo = new Player("David", 3, 0, 0);

        Game game = new Game(playerOne, playerTwo );
        // WHEN
        game.play();
        // THEN
        assertEquals("deuce", game.getStatus());
    }

    @Test
    public void gameScoreShouldBeAdvantage(){
        // GIVEN
        Player playerOne = new Player("Oumaima", 3, 0, 0);
        Player playerTwo = new Player("David", 3, 0, 0);

        Game game = new Game(playerOne, playerTwo );
        game.play();
        playerOne.setGameScore(4);
        // WHEN
        game.play();
        // THEN
        assertEquals("Advantage", game.getStatus());
    }

    @Test
    public void gameScoreShouldBeDeuceAgain(){
        // GIVEN
        Player playerOne = new Player("Oumaima", 3, 0, 0);
        Player playerTwo = new Player("David", 3, 0, 0);

        Game game = new Game(playerOne, playerTwo );
        game.play();
        playerOne.setGameScore(4);
        game.play();
        playerTwo.setGameScore(4);
        // WHEN
        game.play();
        // THEN
        assertEquals("deuce", game.getStatus());
    }
}
