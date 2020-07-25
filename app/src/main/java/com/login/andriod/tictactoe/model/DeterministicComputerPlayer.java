package com.login.andriod.tictactoe.model;

import android.view.View;
import android.widget.Button;

/**
 * Created by Amr on 8/17/2017.
 */

public class DeterministicComputerPlayer extends Player {

    public DeterministicComputerPlayer(Board board, int playerMark) {
        super(board, playerMark);
    }

    @Override
    public void playTurn(View view) {
        if (board.getEmptyCells().size() > 1) {
            int buttonID = board.getEmptyCells().get(0);
            Button buttonSelected = view.getRootView().findViewById(buttonID);
            buttonSelected.setEnabled(false);
            buttonSelected.setBackgroundResource(playerMark);
            addChosenCell(buttonID);
            board.occupyCell(buttonID);
        }
    }

}

