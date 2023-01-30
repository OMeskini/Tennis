package com.game.tennis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Player {

    private String name;
    private Integer gameScore;
    private Integer setScore;
    private Integer matchScore;

    public Player(String name) {
        this.name = name;
        this.gameScore = 0;
        this.setScore = 0;
        this.matchScore = 0;
    }
}
