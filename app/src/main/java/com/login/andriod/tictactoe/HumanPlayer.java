package com.login.andriod.tictactoe;

import java.util.ArrayList;

/**
 * Created by Amr on 8/1/2017.
 */

public class HumanPlayer extends Player {
    @Override
    protected void findcellNumberByID(int buttonid) {
        switch(buttonid){
            case R.id.button1 :
                this.cellNumber=1;
                break;
            case R.id.button2 :
                this.cellNumber=2;
                break;
            case R.id.button3 :
                this.cellNumber=3;
                break;
            case R.id.button4 :
                this.cellNumber=4;
                break;
            case R.id.button5 :
                this.cellNumber=5;
                break;
            case R.id.button6 :
                this.cellNumber=6;
                break;
            case R.id.button7 :
                this.cellNumber=7;
                break;
            case R.id.button8 :
                this.cellNumber=8;
                break;
            case R.id.button9 :
                this.cellNumber=9;
                break;
        }
    }
}
