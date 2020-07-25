package com.login.andriod.tictactoe.model;

import android.view.View;
import android.widget.Button;

/**
 * Model Class: HumanPlayer
 * A Human player model
 * Knows how to play his own turn (operations to execute based on human click).
 * Author: Amr Elzawawy
 * Date: 17-8-2017, Updated on 25-7-2020
 */

public class HumanPlayer extends Player {

    public HumanPlayer(Board board, int playerMark) {
        super(board, playerMark);
    }

    @Override
    public void playTurn(View view) {
        Button buttonSelected = (Button) view;
        // disable the button to avoid re-clicking on it.
        buttonSelected.setEnabled(false);
        // display player's mark on the button selected.
        buttonSelected.setBackgroundResource(playerMark);
        // occupy a cell to be chosen by this player.
        addChosenCell(buttonSelected.getId());
        board.occupyCell(buttonSelected.getId());
    }
}
