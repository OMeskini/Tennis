package com.game.tennis;

public enum GamePoints {
    ZERO(0), Fifteen(15), Thirty(30), Forty(40);

    private final Integer score;

    GamePoints(int score) {
        this.score = score;
    }
    public static Integer score(Integer score)
    {
        switch (score) {
            case 0: return 0;
            case 1: return 15;
            case 2: return 30;
            case 3: return 40;
            default: return score;
        }
    }

}
