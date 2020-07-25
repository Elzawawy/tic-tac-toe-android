package com.login.andriod.tictactoe.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.login.andriod.tictactoe.R;

/**
 * View Class: MainActivity
 * The launcher view where the player chooses the mode of game.
 * Author: Amr Elzawawy
 * Date: 17-8-2017, Updated on 25-7-2020
 */
public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
    }

    public void solo_click(View view) {
        intent = new Intent(MainActivity.this, GameActivity.class);
        intent.putExtra(getString(R.string.intent_extra_key_solo_game_mode), true);
        startActivity(intent);
    }

    public void multiplayer_click(View view) {
        intent = new Intent(MainActivity.this, GameActivity.class);
        intent.putExtra(getString(R.string.intent_extra_key_solo_game_mode), false);
        startActivity(intent);
    }
}
