package com.example.tojiy.myapplication.webview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.tojiy.myapplication.R;
import com.example.tojiy.myapplication.UNVERSALCLASS;

public class WebViewClass extends AppCompatActivity {
    private WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_class);

        if (UNVERSALCLASS.EXSEPTION_URL.trim().contains("dtm_photos/reminder-2018.pdf")) {


            String doc="<iframe src='http://docs.google.com/viewer?url=http://192.168.137.2/dtm_photos/reminder-2018.pdf&embedded=true'width='100%' height='100%'style='border: none;'></iframe>";

            WebView wv = findViewById(R.id.webView);
            wv.getSettings().setJavaScriptEnabled(true);
            wv.loadUrl("https://docs.google.com/viewer?url=http://192.168.137.2/dtm_photos/reminder-2018.pdf");

        }
                //// pdf viewer qilish kerak

//    @Override
//    public void onBackPressed() {
//        if (webView.canGoBack()) {
//            webView.goBack();
//        } else {
//            super.onBackPressed();
//        }
    }
}
