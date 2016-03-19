package com.popularmovies.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
public class PlayTehVidz extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_webview);
        String videoId = getIntent().getStringExtra(MovieFragment.MOVIE_ID);
        final WebView video = (WebView) findViewById(R.id.videoView);
        video.getSettings().setJavaScriptEnabled(true);
        video.getSettings().setPluginState(WebSettings.PluginState.ON);
        video.setWebChromeClient(new WebChromeClient() {
        });
        final String mimeType = "text/html";
        final String encoding = "UTF-8";
        String html = Utility.getVideoHTML(videoId);
        video.loadDataWithBaseURL("", html, mimeType, encoding, "");
    }

}
