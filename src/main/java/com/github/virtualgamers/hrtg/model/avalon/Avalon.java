package com.github.virtualgamers.hrtg.model.avalon;

import javax.persistence.Entity;
import javax.persistence.SecondaryTable;
import com.github.virtualgamers.hrtg.model.AbstractGame;

@Entity(name = "AVALON_TABLE")
@SecondaryTable(name = "GAME_TABLE")
public class Avalon extends AbstractGame {
    private static final long serialVersionUID = 6006474661103018005L;

    Board board;
    Player currentCrown;
    Player currentLake;
    int[] questsLakeOccurs;
    int[] questsLancelotFlips;
    boolean isLancelotAlignmentFlipped;
    int rejectTracker;
    Quest[] quests;
    // Quest quest2;
    // Quest quest3;
    // Quest quest4;
    // Quest quest5;

    public int[] getQuestsLakeOccurs() {
        return questsLakeOccurs;
    }

    public void setQuestsLakeOccurs(final int[] questsLakeOccurs) {
        this.questsLakeOccurs = questsLakeOccurs;
    }

    public int[] getQuestsLancelotFlips() {
        return questsLancelotFlips;
    }

    public void setQuestsLancelotFlips(final int[] questsLancelotFlips) {
        this.questsLancelotFlips = questsLancelotFlips;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(final Board board) {
        this.board = board;
    }

    public Player getCurrentCrown() {
        return currentCrown;
    }

    public void setCurrentCrown(final Player currentCrown) {
        this.currentCrown = currentCrown;
    }

    public Player getCurrentLake() {
        return currentLake;
    }

    public void setCurrentLake(final Player currentLake) {
        this.currentLake = currentLake;
    }

    public boolean isLancelotAlignmentFlipped() {
        return isLancelotAlignmentFlipped;
    }

    public void setLancelotAlignmentFlipped(final boolean isLancelotAlignmentFlipped) {
        this.isLancelotAlignmentFlipped = isLancelotAlignmentFlipped;
    }

    public int getRejectTracker() {
        return rejectTracker;
    }

    public void setRejectTracker(final int rejectTracker) {
        this.rejectTracker = rejectTracker;
    }
}
