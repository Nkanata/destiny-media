package com.dullio.destinyconnectionsmediaapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailedNotificationsActivity extends AppCompatActivity {

    private String message,sender,timestamp;
    private Toolbar toolbar;
    private TextView textView,share,copy;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_notifications);

        Intent intent = getIntent();

        message = intent.getStringExtra("message");
        sender = intent.getStringExtra("sender");
        timestamp = intent.getStringExtra("timestamp");

        toolbar = findViewById(R.id.detailed_notifications_toolbar);
        textView = findViewById(R.id.detailed_notification_message);
        share = findViewById(R.id.detailed_notifications_share);
        copy = findViewById(R.id.detailed_notifications_copy);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(sender);
        actionBar.setSubtitle(timestamp);

        textView.setText(message);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               shareMessage(message);
            }
        });


        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Text copied to clipboard",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void shareMessage(String message){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        intent.setType("text/plain");
        startActivity(intent);
    }

}
