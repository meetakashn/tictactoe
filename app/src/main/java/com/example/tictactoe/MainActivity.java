package com.example.tictactoe;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    ImageButton play;
    MediaPlayer music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.black));
        play = findViewById(R.id.play1);
        music = MediaPlayer.create(MainActivity.this, R.raw.cyberrunmk);
        music.start();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                music.stop();
                Intent intent = new Intent(MainActivity.this, introact.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (music.isPlaying()) {
            music.pause();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!music.isPlaying()) {
            music.start();
        }
    }
}