package com.login.andriod.tictactoe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Amr on 8/10/2017.
 */

public class SoloplayerMode extends AppCompatActivity {
    Player human = new HumanPlayer();
    Player computer = new UIplayer();
    Game game = new Game(human,computer);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_game);
        human.setActive(true);
        ((UIplayer)computer).setEmptyCells();
    }
    public void buClick(View view) {
        game.playSoloMode(view);
        if (human.isWinner()) {
            Toast.makeText(this, "Player X won !", Toast.LENGTH_LONG).show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    finish();
                }
            }, 1500);
        } else if (computer.isWinner()) {
            Toast.makeText(this, "Player O won !", Toast.LENGTH_LONG).show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    finish();
                }
            }, 1500);
        }
    }

}

