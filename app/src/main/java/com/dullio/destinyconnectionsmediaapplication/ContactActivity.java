package com.dullio.destinyconnectionsmediaapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter adapter;
    private static final int SCROLL_DIRECTION_UP = -1;
    private List<DashboardItem> contactList =  new ArrayList<>();

    // Item Decorator variables
    private static int SPACING = 16,COLUMNS = 1;
    private boolean includeEdges = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        toolbar = findViewById(R.id.contact_toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.contact_module));
        actionBar.setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.contact_recyclerView);
        manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new ItemDecorator(COLUMNS,SPACING,includeEdges));


        if(recyclerView.canScrollVertically(SCROLL_DIRECTION_UP)){
            actionBar.setElevation(0f);

        }else{

            actionBar.setElevation(getResources().getDimension(R.dimen.toolbar_elevation));
        }


        contactList.add(new DashboardItem(getResources().getString(R.string.contact_visit),getResources().getString(R.string.contact_visit_description),getResources().getString(R.string.contact_visit_action),R.drawable.visit_us));
        contactList.add(new DashboardItem(getResources().getString(R.string.contact_call),getResources().getString(R.string.contact_call_description),getResources().getString(R.string.contact_call_action),R.drawable.call_us));
        contactList.add(new DashboardItem(getResources().getString(R.string.contact_Email),getResources().getString(R.string.contact_email_description),getResources().getString(R.string.contact_email_action),R.drawable.send_us_an_email));

        adapter = new DetailedDashboardRecyclerAdapter(getApplicationContext(),contactList);
       recyclerView.setAdapter(adapter);

    }

    private void sendEmail (){

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:contact@destinyfm.co.ke"));

        if (intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }

    }
}
