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
        isSoloGameMode = getIntent().getBooleanExtra("SOLO_GAME_MODE", true);
        setupActivity();
    }

    public void buClick(View view) {
        if (isSoloGameMode)
            game.playSoloMode(view);
        else
            game.playMultiMode(view);
        // check winning  or tie condition and show appropriate notification accordingly.
        if (player1.isWinner())
            notifyResultAndEndGame("Player X won !");
        else if (player2.isWinner())
            notifyResultAndEndGame("Player O won !");
        else if (isTieGame())
            notifyResultAndEndGame("It's a Tie Game. Shake Hands !");
    }

    private void setupActivity() {
        player1 = new HumanPlayer();
        player1.setActive(true);
        player2 = isSoloGameMode ? new UIplayer() : new HumanPlayer();
        if (isSoloGameMode)
            ((UIplayer) player2).setEmptyCells();
        game = new Game(player1, player2);
    }

    private void notifyResultAndEndGame(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                finish();
            }
        }, 1500);
    }

    private boolean isTieGame() {
        return player1.getCellsChoosen().size() + player2.getCellsChoosen().size() == 9;
    }
}