package com.login.andriod.tictactoe.controller;

import android.view.View;

import com.login.andriod.tictactoe.model.Board;
import com.login.andriod.tictactoe.model.Player;

import java.util.ArrayList;

/**
 * Controller Class: GameController
 * Alternates turns between players and asks them to take actions.
 * Knows Winning Condition Logic (using Board structure) queried about from View Class.
 * Knows Tie Condition Logic (using Board structure) queried about from View Class.
 * Author: Amr Elzawawy
 * Date: 17-8-2017, Updated on 25-7-2020
 */

public class GameController {
    private Player Player1;
    private Player Player2;
    private Board board;

    public GameController(Board board, Player player1, Player player2) {
        this.board = board;
        this.Player1 = player1;
        this.Player2 = player2;
    }

    public void playMultiMode(View view) {
        if (Player1.isActive()) {
            Player1.playTurn(view);
            Player2.setActive(true);
            Player1.setActive(false);

        } else if (Player2.isActive()) {
            Player2.playTurn(view);
            Player1.setActive(true);
            Player2.setActive(false);
        }
    }

    public void playSoloMode(View view) {
        if (Player1.isActive()) {
            Player1.playTurn(view);
            Player2.setActive(true);
            Player1.setActive(false);
            // Call the Function again to trigger the AI Player to play his turn.
            playSoloMode(view);

        } else if (Player2.isActive()) {
            Player2.playTurn(view);
            Player2.setActive(false);
            Player1.setActive(true);
        }
    }

    public boolean isTieGame() {
        return Player1.getCellsChosen().size() + Player2.getCellsChosen().size() == Board.BOARD_CELLS_NUMBER;
    }

    public boolean isPlayerWinner(Player player) {
        for (ArrayList<Integer> winningArray : board.getWinningCells())
            if (player.getCellsChosen().containsAll(winningArray))
                return true;
        return false;
    }
}
