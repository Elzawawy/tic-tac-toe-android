package com.login.andriod.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MultiplayerMode extends AppCompatActivity {
    HumanPlayer humanPlayer1 = new HumanPlayer();
    HumanPlayer humanPlayer2 = new HumanPlayer();
    Game game = new Game(humanPlayer1,humanPlayer2);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_game);
        humanPlayer1.setActive(true);
    }

    public void buClick(View view) {
        game.playMultiMode(view);
        if(humanPlayer1.isWinner() || humanPlayer2.isWinner()){
            finish();
        }
    }

}
