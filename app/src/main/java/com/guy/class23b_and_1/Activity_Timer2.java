package com.guy.class23b_and_1;

import android.media.MediaActionSound;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textview.MaterialTextView;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Activity_Timer2 extends AppCompatActivity {

    private MaterialTextView lbl;

    private MediaActionSound sound = new MediaActionSound();
    private final int DELAY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        lbl = findViewById(R.id.lbl);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startTimer();
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopTimer();
    }

    private void ticker() {
        Log.d("pttt", "Hi");
        sound.play(MediaActionSound.START_VIDEO_RECORDING);

        SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss", Locale.US);
        String time = df.format(System.currentTimeMillis());
        lbl.setText(time);
    }

    // ------------------- ------------------- ------------------- -------------------


    private Timer timer = null;

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Log.d("pttt", "A:" + Thread.currentThread().getName());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("pttt", "B:" + Thread.currentThread().getName());
                        ticker();
                    }
                });
            }
        }, 0, DELAY);
    }

    private void stopTimer() {
        timer.cancel();
    }
}