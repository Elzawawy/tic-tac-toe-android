package com.login.andriod.tictactoe;

import java.util.ArrayList;

/**
 * Created by Amr on 8/17/2017.
 */

public abstract class Player {
    protected boolean active;
    protected ArrayList<Integer> cellsChoosen = new ArrayList<>();
    protected int cellNumber;
    public int getCellNumber() {
        return cellNumber;
    }

    public ArrayList<Integer> getCellsChoosen() {
        return cellsChoosen;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCell(Integer cellNumber){
        cellsChoosen.add(cellNumber);
    }
    public boolean isWinner(){
        if(cellsChoosen.contains(1)&& cellsChoosen.contains(2)&&cellsChoosen.contains(3) ||
                cellsChoosen.contains(4)&& cellsChoosen.contains(5)&&cellsChoosen.contains(6)    ||
                cellsChoosen.contains(7) && cellsChoosen.contains(8)&&cellsChoosen.contains(9)   ||
                cellsChoosen.contains(1) && cellsChoosen.contains(4)&&cellsChoosen.contains(7)   ||
                cellsChoosen.contains(2) && cellsChoosen.contains(5)&&cellsChoosen.contains(8)   ||
                cellsChoosen.contains(3) && cellsChoosen.contains(6)&&cellsChoosen.contains(9)   ||
                cellsChoosen.contains(1) && cellsChoosen.contains(5)&&cellsChoosen.contains(9)   ||
                cellsChoosen.contains(3) && cellsChoosen.contains(5)&&cellsChoosen.contains(7)   )
        {
            return true;
        }
        return false;
    }
    protected abstract void findcellNumberByID(int buttonid) ;
}
