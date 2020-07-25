package com.login.andriod.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    private Player player1;
    private Player player2;
    private boolean isSoloGameMode;
    private Game game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        boolean isSoloGameMode = getIntent().getBooleanExtra("SOLO_GAME_MODE",true);
        setupActivity(isSoloGameMode);
    }

    public void buClick(View view) {
        game.playMultiMode(view);
        if (player1.isWinner()) {
            Toast.makeText(this, "Player X won !", Toast.LENGTH_LONG).show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    finish();
                }
            }, 1500);
        } else if (player2.isWinner()) {
            Toast.makeText(this, "Player O won !", Toast.LENGTH_LONG).show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    finish();
                }
            }, 1500);
        }
        else if(player1.getCellsChoosen().size()+player2.getCellsChoosen().size() == 9){
            Toast.makeText(this, "It's a Tie Game. Shake Hands !", Toast.LENGTH_LONG).show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    finish();
                }
            }, 1500);
        }
    }

    private void setupActivity(boolean isSoloGameMode){
        player1 = new HumanPlayer();
        player1.setActive(true);
        player2 = isSoloGameMode? new UIplayer(): new HumanPlayer();
        if(isSoloGameMode)
            ((UIplayer)player2).setEmptyCells();
        game = new Game(player1,player2);
    }
}