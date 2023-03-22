package com.guy.class23b_and_1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaActionSound;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.google.android.material.textview.MaterialTextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Activity_Timer extends AppCompatActivity {

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



    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        public void run() {
            handler.postDelayed(runnable, DELAY);
            ticker();
        }
    };

    private void startTimer() {
        handler.postDelayed(runnable, DELAY);
    }

    private void stopTimer() {
        handler.removeCallbacks(runnable);
    }
}