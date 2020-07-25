package com.login.andriod.tictactoe.model;

import com.login.andriod.tictactoe.R;

import java.util.ArrayList;
import java.util.Arrays;

/** Model Class: Board
 * Holds information about the board structure and relation to button IDs.
 * Keeps track of empty cells available each turn update
 * Author: Amr Elzawawy
 * Date: 25-7-2020
 */
public class Board {
    private ArrayList<Integer> emptyCells = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> winningCells = new ArrayList<>();
    public static int BOARD_CELLS_NUMBER = 9;

    public Board() {
        initEmptyCells();
        initWinningCells();
    }

    // getter method for empty cells data structure. (changes with instances)
    public ArrayList<Integer> getEmptyCells() {
        return emptyCells;
    }

    // getter method for winning cells data structure. (never changes with instances)
    public ArrayList<ArrayList<Integer>> getWinningCells() {
        return winningCells;
    }

    // occupy cell == remove from empty cells data structure.
    public void occupyCell(Integer buttonID) {
        if (emptyCells.size() >= 1)
            emptyCells.remove(buttonID);
    }

    private void initEmptyCells() {
        emptyCells.add(R.id.button1);
        emptyCells.add(R.id.button2);
        emptyCells.add(R.id.button3);
        emptyCells.add(R.id.button4);
        emptyCells.add(R.id.button5);
        emptyCells.add(R.id.button6);
        emptyCells.add(R.id.button7);
        emptyCells.add(R.id.button8);
        emptyCells.add(R.id.button9);
    }

    private void initWinningCells() {
        // ROWS Winning Condition.
        winningCells.add(new ArrayList<>(Arrays.asList(R.id.button1, R.id.button2, R.id.button3)));
        winningCells.add(new ArrayList<>(Arrays.asList(R.id.button4, R.id.button5, R.id.button6)));
        winningCells.add(new ArrayList<>(Arrays.asList(R.id.button3, R.id.button6, R.id.button9)));
        // COLS Winning Condition.
        winningCells.add(new ArrayList<>(Arrays.asList(R.id.button1, R.id.button4, R.id.button7)));
        winningCells.add(new ArrayList<>(Arrays.asList(R.id.button2, R.id.button5, R.id.button8)));
        winningCells.add(new ArrayList<>(Arrays.asList(R.id.button3, R.id.button6, R.id.button9)));
        // Diagonals Winning Condition.
        winningCells.add(new ArrayList<>(Arrays.asList(R.id.button1, R.id.button5, R.id.button9)));
        winningCells.add(new ArrayList<>(Arrays.asList(R.id.button3, R.id.button5, R.id.button7)));
    }
}
