package com.example.tictactoe;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class introact extends AppCompatActivity {
    ImageButton Bt1, Bt2, Bt3, Bt4, Bt5, Bt6, Bt7, Bt8, Bt9;
    String b1 = "", b2 = "", b3 = "", b4 = "", b5 = "", b6 = "", b7 = "", b8 = "", b9 = "";
    ImageView winner, right1, right2;
    MediaPlayer m1, m2, draw, win;
    int flag = 0;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introact);
        getWindow().setStatusBarColor(ContextCompat.getColor(introact.this, R.color.black));
        m1 = MediaPlayer.create(introact.this, R.raw.click);
        m2 = MediaPlayer.create(introact.this, R.raw.gamebouns);
        draw = MediaPlayer.create(introact.this, R.raw.child);
        win = MediaPlayer.create(introact.this, R.raw.gamebouns);
        right1 = findViewById(R.id.right1);
        right2 = findViewById(R.id.right2);
        right2.setVisibility(View.INVISIBLE);
        init();
    }

    private void init() {
        Bt1 = findViewById(R.id.bt1);
        Bt2 = findViewById(R.id.bt2);
        Bt3 = findViewById(R.id.bt3);
        Bt4 = findViewById(R.id.bt4);
        Bt5 = findViewById(R.id.bt5);
        Bt6 = findViewById(R.id.bt6);
        Bt7 = findViewById(R.id.bt7);
        Bt8 = findViewById(R.id.bt8);
        Bt9 = findViewById(R.id.bt9);
    }

    public void check(View v) {
        m1.start();
        ImageButton current = (ImageButton) v;
        count++;
        if (flag == 0) {
            current.setBackgroundResource(R.drawable.xbutton);
            store(v);
            current.setEnabled(false);
            flag = 1;
            right1.setVisibility(View.INVISIBLE);
            right2.setVisibility(View.VISIBLE);
        } else {
            current.setBackgroundResource(R.drawable.obutton);
            store(v);
            current.setEnabled(false);
            flag = 0;
            right1.setVisibility(View.VISIBLE);
            right2.setVisibility(View.INVISIBLE);
        }
        // player win check
        if (count > 4) {
            winner = findViewById(R.id.winner);
            // Conditions
            if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")) {
                win.start();
                if (b1 == "x")
                    winner.setBackgroundResource(R.drawable.winnerx);
                else
                    winner.setBackgroundResource(R.drawable.winnero);
                restart();
                inset();
            } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")) {
                win.start();
                if (b4 == "x")
                    winner.setBackgroundResource(R.drawable.winnerx);
                else
                    winner.setBackgroundResource(R.drawable.winnero);
                restart();
                inset();
            } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")) {
                win.start();
                if (b7 == "x")
                    winner.setBackgroundResource(R.drawable.winnerx);
                else
                    winner.setBackgroundResource(R.drawable.winnero);
                restart();
                inset();
            } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")) {
                win.start();
                if (b1 == "x")
                    winner.setBackgroundResource(R.drawable.winnerx);
                else
                    winner.setBackgroundResource(R.drawable.winnero);
                restart();
                inset();
            } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")) {
                win.start();
                if (b2 == "x")
                    winner.setBackgroundResource(R.drawable.winnerx);
                else
                    winner.setBackgroundResource(R.drawable.winnero);
                restart();
                inset();
            } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")) {
                win.start();
                if (b3 == "x")
                    winner.setBackgroundResource(R.drawable.winnerx);
                else
                    winner.setBackgroundResource(R.drawable.winnero);
                restart();
                inset();
            } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")) {
                win.start();
                if (b1 == "x")
                    winner.setBackgroundResource(R.drawable.winnerx);
                else
                    winner.setBackgroundResource(R.drawable.winnero);
                restart();
                inset();
            } else if (b3.equals(b5) && b5.equals(b7) && !b5.equals("")) {
                win.start();
                if (b3 == "x")
                    winner.setBackgroundResource(R.drawable.winnerx);
                else
                    winner.setBackgroundResource(R.drawable.winnero);
                restart();
                inset();
            } else if (count == 9) {
                draw.start();
                winner.setBackgroundResource(R.drawable.matchdraw);
                restart();
                inset();
            }
        }
    }

    // Storing x or o  in  string
    public void store(View view) {
        ImageButton current = (ImageButton) view;
        if (current == Bt1) {
            if (flag == 0) b1 = "x";
            else b1 = "o";
        } else if (current == Bt2) {
            if (flag == 0) b2 = "x";
            else b2 = "o";
        } else if (current == Bt3) {
            if (flag == 0) b3 = "x";
            else b3 = "o";
        } else if (current == Bt4) {
            if (flag == 0) b4 = "x";
            else b4 = "o";
        } else if (current == Bt5) {
            if (flag == 0) b5 = "x";
            else b5 = "o";
        } else if (current == Bt6) {
            if (flag == 0) b6 = "x";
            else b6 = "o";
        } else if (current == Bt7) {
            if (flag == 0) b7 = "x";
            else b7 = "o";
        } else if (current == Bt8) {
            if (flag == 0) b8 = "x";
            else b8 = "o";
        } else if (current == Bt9) {
            if (flag == 0) b9 = "x";
            else b9 = "o";
        }
    }

    public void restart() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Bt1.setBackgroundResource(R.drawable.org);
                Bt2.setBackgroundResource(R.drawable.org);
                Bt3.setBackgroundResource(R.drawable.org);
                Bt4.setBackgroundResource(R.drawable.org);
                Bt5.setBackgroundResource(R.drawable.org);
                Bt6.setBackgroundResource(R.drawable.org);
                Bt7.setBackgroundResource(R.drawable.org);
                Bt8.setBackgroundResource(R.drawable.org);
                Bt9.setBackgroundResource(R.drawable.org);
                Bt1.setEnabled(true);
                Bt2.setEnabled(true);
                Bt3.setEnabled(true);
                Bt4.setEnabled(true);
                Bt5.setEnabled(true);
                Bt6.setEnabled(true);
                Bt7.setEnabled(true);
                Bt8.setEnabled(true);
                Bt9.setEnabled(true);
                right1.setVisibility(View.VISIBLE);
                winner.setBackgroundColor(Color.TRANSPARENT);
                flag = 0;
                count = 0;
                b1 = "";
                b2 = "";
                b3 = "";
                b4 = "";
                b5 = "";
                b6 = "";
                b7 = "";
                b8 = "";
                b9 = "";
            }
        }, 1000);

    }

    public void inset() {
        right1.setVisibility(View.INVISIBLE);
        right2.setVisibility(View.INVISIBLE);
    }

    // Music
    @Override
    protected void onPause() {
        super.onPause();
        if (m1.isPlaying()) {
            m1.pause();
        }
        if (m2.isPlaying()) {
            m2.pause();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!m1.isPlaying()) {
            m1.start();
        }
        if (!m2.isPlaying()) {
            m2.start();
        }
    }

}