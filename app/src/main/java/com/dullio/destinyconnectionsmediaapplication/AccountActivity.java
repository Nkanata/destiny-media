package com.dullio.destinyconnectionsmediaapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AccountActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;
    private TextView textView,userEmail,userName;
    private RecyclerView recyclerView;
    private LinearLayout emptyView,accountDetailsLayout;
    private ImageView userImage;
    boolean isDetailsOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        toolbar = findViewById(R.id.account_toolbar);
        recyclerView = findViewById(R.id.account_details_recyclerView);
        emptyView = findViewById(R.id.empty_account_details);

        userEmail = findViewById(R.id.account_email);
        userImage = findViewById(R.id.account_image);
        userName = findViewById(R.id.account_username);
        accountDetailsLayout = findViewById(R.id.account_details_layout);


        textView = findViewById(R.id.about);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setTitle(getResources().getString(R.string.account_and_settings));



        userEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isDetailsOpen){
                    isDetailsOpen = false;
                    accountDetailsLayout.setVisibility(View.GONE);
                    userEmail.setCompoundDrawablesWithIntrinsicBounds(null,null,null,getResources().getDrawable(R.drawable.ic_keyboard_arrow_down_black_24dp));
                }else{
                accountDetailsLayout.setVisibility(View.VISIBLE);
                isDetailsOpen = true;
                userEmail.setCompoundDrawablesWithIntrinsicBounds(null,null,null,getResources().getDrawable(R.drawable.ic_keyboard_arrow_up_black_24dp));
                }
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AboutActivity.class);
                startActivity(intent);
            }
        });


    }
}
