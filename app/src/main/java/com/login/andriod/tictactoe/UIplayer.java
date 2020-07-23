package com.login.andriod.tictactoe;

import java.util.ArrayList;

/**
 * Created by Amr on 8/17/2017.
 */

public class UIplayer extends Player{
    private ArrayList<Integer> emptyCells = new ArrayList<>();
    @Override
    protected void findcellNumberByID(int buttonid) {
            switch(buttonid){
                case 1:
                    this.cellNumber=R.id.button1;
                    break;
                case 2:
                    this.cellNumber=R.id.button2;
                    break;
                case 3 :
                    this.cellNumber=R.id.button3;
                    break;
                case 4 :
                    this.cellNumber=R.id.button4;
                    break;
                case 5 :
                    this.cellNumber=R.id.button5;
                    break;
                case 6 :
                    this.cellNumber=R.id.button6;
                    break;
                case 7 :
                    this.cellNumber=R.id.button7;
                    break;
                case 8 :
                    this.cellNumber=R.id.button8;
                    break;
                case 9 :
                    this.cellNumber=R.id.button9;
                    break;
            }
        }

    public ArrayList<Integer> getEmptyCells() {
        return emptyCells;
    }

    public void setEmptyCells() {
        for(int i=1;i<10;i++) {
            this.emptyCells.add(i);
        }
    }
}

