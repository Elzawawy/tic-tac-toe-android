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
    private ArrayList<Integer> emptyCells;
    public Game(Player player1,Player player2){
        this.Player1=player1;
        this.Player2=player2;
        this.emptyCells = ((UIplayer)Player2).getEmptyCells();
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
        if(Player1.isActive()){
            Button buselected = (Button)view;
            buselected.setEnabled(false);
            Player1.findcellNumberByID(buselected.getId());
            buselected.setBackgroundResource(R.drawable.x);
            Player2.setActive(true);
            Player1.setActive(false);
            Player1.setCell(Player1.getCellNumber());
            if(emptyCells.size() > 1)
                emptyCells.remove((Integer) Player1.getCellNumber());
            playSoloMode(view);
        }
        else if(Player2.isActive()) {
            int index = emptyCells.get(0);
            Player2.findcellNumberByID(index);
            System.out.println("DEBUG "+index);
            Button buselected = view.getRootView().findViewById(Player2.cellNumber);
            buselected.setEnabled(false);
            buselected.setBackgroundResource(R.drawable.o);
            Player2.setActive(false);
            Player1.setActive(true);
            Player2.setCell(index);
            if(emptyCells.size() > 1)
                emptyCells.remove(0);
        }

    }

}
