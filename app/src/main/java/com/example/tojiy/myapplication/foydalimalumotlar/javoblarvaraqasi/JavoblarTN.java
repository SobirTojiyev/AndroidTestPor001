package com.example.tojiy.myapplication.foydalimalumotlar.javoblarvaraqasi;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.tojiy.myapplication.R;

public class JavoblarTN extends AppCompatActivity {

    String vidAddress = "http://192.168.57.2/shohruhxon.mp4";
    Uri vidUri = Uri.parse(vidAddress);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test_topshiriq);
        final MediaController vidControl = new MediaController(this);
        final VideoView vidView = findViewById(R.id.myVideo);
        vidView.setVideoURI(vidUri);
        vidView.requestFocus();
        vidView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                vidView.start();
            }
        });
//
//        vidControl.setAnchorView(vidView);
//        vidView.setMediaController(vidControl);
//        vidView.start();

    }
}
