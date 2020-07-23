package com.login.andriod.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MultiplayerMode extends AppCompatActivity {
    HumanPlayer humanPlayer1 = new HumanPlayer();
    HumanPlayer humanPlayer2 = new HumanPlayer();
    Game game = new Game(humanPlayer1, humanPlayer2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_game);
        humanPlayer1.setActive(true);
    }

    public void buClick(View view) {
        game.playMultiMode(view);
        if (humanPlayer1.isWinner()) {
            Toast.makeText(this, "Player X won !", Toast.LENGTH_LONG).show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    finish();
                }
            }, 1500);
        } else if (humanPlayer2.isWinner()) {
            Toast.makeText(this, "Player O won !", Toast.LENGTH_LONG).show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    finish();
                }
            }, 1500);
        }
        else if(humanPlayer1.getCellsChoosen().size()+humanPlayer2.getCellsChoosen().size() == 9){
            Toast.makeText(this, "It's a Tie Game. Shake Hands !", Toast.LENGTH_LONG).show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    finish();
                }
            }, 1500);
        }
    }
}
