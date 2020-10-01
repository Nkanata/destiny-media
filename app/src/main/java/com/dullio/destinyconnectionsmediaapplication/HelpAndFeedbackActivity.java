package com.dullio.destinyconnectionsmediaapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HelpAndFeedbackActivity extends AppCompatActivity {

    Toolbar toolbar;
    RecyclerView recyclerView;
    ActionBar actionBar;
    TextView sendFeedback;
    private List<FAQ> faqList = new ArrayList<>();
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_and_feedback);

        toolbar = findViewById(R.id.help_toolbar);
        recyclerView = findViewById(R.id.help_recyclerView);
        sendFeedback = findViewById(R.id.send_feedback);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getResources().getString(R.string.feedback_module));

        manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);

        faqList.add(new FAQ(getResources().getString(R.string.faq_user_ID),getResources().getString(R.string.faq_user_ID_description)));
        faqList.add(new FAQ(getResources().getString(R.string.faq_receipt),getResources().getString(R.string.faq_receipt_description)));

        adapter = new FAQRecyclerAdapter(getApplicationContext(),faqList);
        recyclerView.setAdapter(adapter);

        sendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }
        });
    }

    private void sendEmail (){

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:contact@destinyfm.co.ke"));

        if (intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }

    }
}
