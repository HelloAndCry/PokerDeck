package com.game.texasholdem;


public enum CardSuitEnum {
    HEARTS("H"),
    DIAMONDS("D"),
    SPADES("S"),
    CLUBS("C");

    private String name;

    CardSuitEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
