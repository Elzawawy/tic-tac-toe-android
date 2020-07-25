package com.login.andriod.tictactoe.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.login.andriod.tictactoe.R;
import com.login.andriod.tictactoe.controller.GameController;
import com.login.andriod.tictactoe.model.Board;
import com.login.andriod.tictactoe.model.DeterministicComputerPlayer;
import com.login.andriod.tictactoe.model.HumanPlayer;
import com.login.andriod.tictactoe.model.Player;

import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends AppCompatActivity {
    private Player player1;
    private Player player2;
    private boolean isSoloGameMode;
    private GameController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        isSoloGameMode = getIntent().getBooleanExtra("SOLO_GAME_MODE", true);
        setupActivity();
    }

    public void buClick(View view) {
        if (isSoloGameMode)
            controller.playSoloMode(view);
        else
            controller.playMultiMode(view);
        // check winning  or tie condition and show appropriate notification accordingly.
        if (controller.isPlayerWinner(player1))
            notifyResultAndEndGame("Player X won !");
        else if (controller.isPlayerWinner(player2))
            notifyResultAndEndGame("Player O won !");
        else if (controller.isTieGame())
            notifyResultAndEndGame("It's a Tie Game. Shake Hands !");
    }

    private void setupActivity() {
        Board board = new Board();
        player1 = new HumanPlayer(board, R.drawable.x);
        player1.setActive(true);
        player2 = isSoloGameMode ? new DeterministicComputerPlayer(board, R.drawable.o) : new HumanPlayer(board, R.drawable.o);
        controller = new GameController(board, player1, player2);
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
}