package com.login.andriod.tictactoe;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by Amr on 8/17/2017.
 */

public class Game {
    private Player Player1;
    private Player Player2;
    public Game(Player player1,Player player2){
        this.Player1=player1;
        this.Player2=player2;
    }
    public void playMultiMode(View view){
        Button buselected = (Button)view;
        buselected.setEnabled(false);
        if(Player1.isActive()){
            Player1.findcellNumberByID(buselected.getId());
            buselected.setBackgroundResource(R.drawable.x);
            Player2.setActive(true);
            Player1.setActive(false);
            Player1.setCell(Player1.getCellNumber());
        }
        else if(Player2.isActive()) {
            Player2.findcellNumberByID(buselected.getId());
            buselected.setBackgroundResource(R.drawable.o);
            Player1.setActive(true);
            Player2.setActive(false);
            Player2.setCell(Player2.getCellNumber());
        }
    }
    public void playSoloMode(View view){
        ArrayList<Integer> emptyCells = ((UIplayer)Player2).getEmptyCells();
        if(Player1.isActive()){
            Button buselected = (Button)view;
            buselected.setEnabled(false);
            Player1.findcellNumberByID(buselected.getId());
            buselected.setBackgroundResource(R.drawable.x);
            Player2.setActive(true);
            Player1.setActive(false);
            Player1.setCell(Player1.getCellNumber());
            emptyCells.remove(Player1.getCellNumber());

        }
        else if(Player2.isActive()) {



        }

    }

}
