package com.github.virtualgamers.hrtg.model.avalon;

public enum Board {
    FIVE_PLAYERS(5, 2, 2, 3, 2, 3, 3, false),

    SIX_PLAYERS(6, 2, 2, 3, 4, 3, 4, false),

    SEVEN_PLAYERS(7, 3, 2, 3, 3, 4, 4, true),

    EIGHT_PLAYERS(8, 3, 3, 4, 4, 5, 5, true),

    NINE_PLAYERS(9, 3, 3, 4, 4, 5, 5, true),

    TEN_PLAYERS(10, 4, 3, 4, 4, 5, 5, true);

    private final int players;
    private final int minionsOfMordred;
    private final int quest1Size;
    private final int quest2Size;
    private final int quest3Size;
    private final int quest4Size;
    private final int quest5Size;
    private final boolean twoFailsRequired;

    private Board(final int players, final int minionsOfMordred, final int quest1Size,
            final int quest2Size, final int quest3Size, final int quest4Size, final int quest5Size,
            final boolean twoFailsRequired) {
        this.players = players;
        this.minionsOfMordred = minionsOfMordred;
        this.quest1Size = quest1Size;
        this.quest2Size = quest2Size;
        this.quest3Size = quest3Size;
        this.quest4Size = quest4Size;
        this.quest5Size = quest5Size;
        this.twoFailsRequired = twoFailsRequired;
    }

    public int getPlayers() {
        return players;
    }

    public int getMinionsOfMordred() {
        return minionsOfMordred;
    }

    public int getQuest1Size() {
        return quest1Size;
    }

    public int getQuest2Size() {
        return quest2Size;
    }

    public int getQuest3Size() {
        return quest3Size;
    }

    public int getQuest4Size() {
        return quest4Size;
    }

    public int getQuest5Size() {
        return quest5Size;
    }

    public boolean isTwoFailsRequired() {
        return twoFailsRequired;
    }
}
