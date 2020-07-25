package com.login.andriod.tictactoe.model;

import android.view.View;

import java.util.ArrayList;

/** Model Class: Player
 * Abstract Player class for all specific player classes
 * Holds the Board Instance injected by View.
 * Holds the mark sign (X or O).
 * Holds the cells chosen so far by a player.
 * Author: Amr Elzawawy
 * Date: 17-8-2017, Updated on 25-7-2020
 */

public abstract class Player {
    protected boolean active;
    protected ArrayList<Integer> cellsChosen = new ArrayList<>();
    protected Board board;
    protected int playerMark;

    public Player(Board board, int playerMark) {
        this.board = board;
        this.playerMark = playerMark;
    }

    public ArrayList<Integer> getCellsChosen() {
        return cellsChosen;
    }

    public void addChosenCell(Integer cellNumber) {
        cellsChosen.add(cellNumber);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public abstract void playTurn(View view);
}
