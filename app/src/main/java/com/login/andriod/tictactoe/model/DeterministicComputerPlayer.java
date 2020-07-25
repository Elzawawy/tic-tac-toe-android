package com.login.andriod.tictactoe.model;

import android.view.View;
import android.widget.Button;

/**
 * Model Class: DeterministicComputerPlayer
 * A Computer player model that is dummy and plays the same pattern of moves each time.
 * Knows how to play his own turn (operations to execute based on human click).
 * Author: Amr Elzawawy
 * Date: 17-8-2017, Updated on 25-7-2020
 */

public class DeterministicComputerPlayer extends Player {

    public DeterministicComputerPlayer(Board board, int playerMark) {
        super(board, playerMark);
    }

    @Override
    public void playTurn(View view) {
        // make sure the computer agent never makes a violated move on board.
        if (board.getEmptyCells().size() > 1) {
            // this is where the deterministic logic comes from. It chooses index ) each time.
            int buttonID = board.getEmptyCells().get(0);
            Button buttonSelected = view.getRootView().findViewById(buttonID);
            // disable the button to avoid re-clicking on it.
            buttonSelected.setEnabled(false);
            // display player's mark on the button selected.
            buttonSelected.setBackgroundResource(playerMark);
            // occupy a cell to be chosen by this player.
            addChosenCell(buttonID);
            board.occupyCell(buttonID);
        }
    }

}

