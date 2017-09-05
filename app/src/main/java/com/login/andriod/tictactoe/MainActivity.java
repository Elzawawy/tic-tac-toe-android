package com.login.andriod.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.button1);
        button2=(Button)findViewById(R.id.button2);
    }

    public void solo_click(View view) {
        intent = new Intent(MainActivity.this,MultiplayerMode.class);
        startActivity(intent);
    }

    public void multiplayer_click(View view) {
    }
}
