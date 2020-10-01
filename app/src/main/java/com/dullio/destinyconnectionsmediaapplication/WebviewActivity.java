package com.dullio.destinyconnectionsmediaapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class WebviewActivity extends AppCompatActivity {

    Toolbar toolbar;
    WebView webView;
    ActionBar actionBar;
    ProgressBar progressBar;

    private static String URL = "http://www.destinyfm.co.ke/";


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.webview_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()== R.id.navigation_view_original_webPage){
            viewInBrowser(URL);
            return true;
        }

        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        toolbar = findViewById(R.id.webview_toolbar);
        progressBar = findViewById(R.id.webview_progress);
        setSupportActionBar(toolbar);

        webView = findViewById(R.id.webview);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getResources().getString(R.string.navigation_view_website));

        webView.loadUrl(URL);
        webView.setWebViewClient( new MyWebViewClient());
    }


    private class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            webView.loadUrl(URL);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            progressBar.setVisibility(View.GONE);

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            progressBar.setVisibility(View.GONE);

        }
    }

    private void viewInBrowser(String link){

        Uri uri = Uri.parse(link);
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);

        if (intent.resolveActivity(this.getPackageManager()) != null){
            startActivity(intent);
        }

    }


}
