package com.example.tojiy.myapplication.foydalimalumotlar.javoblarvaraqasi;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.tojiy.myapplication.R;

public class JavoblarTN extends AppCompatActivity {

    String vidAddress = "http://192.168.57.2/shohruhxon.mp4";
    MediaController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_topshiriq);

        VideoView videoView = findViewById(R.id.myVideo);
        Uri vidUri = Uri.parse(vidAddress);
        videoView.setVideoURI(vidUri);
        videoView.requestFocus();
        mc = new MediaController(this);
        mc.setAnchorView(videoView);
        videoView.setMediaController(mc);
//        mc.show();
        videoView.start();

    }
}

//
//        vidControl.setAnchorView(vidView);
//        vidView.setMediaController(vidControl);
//        vidView.start();

