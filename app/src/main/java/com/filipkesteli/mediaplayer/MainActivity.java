package com.filipkesteli.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnToggle;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMediaPlayer();
        initWidgets();
        setupListeners();
    }

    private void initMediaPlayer() {
        mediaPlayer = MediaPlayer.create(this, R.raw.zika);
    }

    private void initWidgets() {
        btnToggle = (Button) findViewById(R.id.btnToggle);
    }

    private void setupListeners() {
        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MediaPlayer radi sinhrono -> stoji na toj liniji koda. nije asinhrono
                //imamo play i stop
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    btnToggle.setText(R.string.play);
                } else {
                    mediaPlayer.start();
                    btnToggle.setText(R.string.stop);
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.release();
    }
}
