package com.login.andriod.tictactoe.model;

import android.view.View;
import android.widget.Button;

/**
 * Created by Amr on 8/1/2017.
 */

public class HumanPlayer extends Player {

    public HumanPlayer(Board board, int playerMark) {
        super(board, playerMark);
    }

    @Override
    public void playTurn(View view) {
        Button buttonSelected = (Button)view;
        // disable the button to avoid re-clicking on it.
        buttonSelected.setEnabled(false);
        buttonSelected.setBackgroundResource(playerMark);
        // occupy a cell to be chosen by this player.
        addChosenCell(buttonSelected.getId());
        board.occupyCell(buttonSelected.getId());
    }
}
