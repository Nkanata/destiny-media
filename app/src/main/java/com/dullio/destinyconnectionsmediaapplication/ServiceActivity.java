package com.dullio.destinyconnectionsmediaapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ServiceActivity extends AppCompatActivity {

    Toolbar toolbar;
    ActionBar actionBar;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    private static final int SCROLL_DIRECTION_UP = -1;
    private RecyclerView.LayoutManager manager;
    private List<DashboardItem> servicesList = new ArrayList<>();
    // Item Decorator variables
    private static int SPACING = 16,COLUMNS = 1;
    private boolean includeEdges = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        // Finding views
        toolbar = findViewById(R.id.service_toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.services_module));
        actionBar.setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.service_recyclerView);

        // Declarations related to recycler view
        manager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(new ItemDecorator(COLUMNS,SPACING,includeEdges));

        if(recyclerView.canScrollVertically(SCROLL_DIRECTION_UP)){
            actionBar.setElevation(0f);

        }else{

            actionBar.setElevation(getResources().getDimension(R.dimen.toolbar_elevation));
        }

        servicesList.add(new DashboardItem(getResources().getString(R.string.service_training),getResources().getString(R.string.service_training_description),getResources().getString(R.string.service_training_action),R.drawable.training));
        servicesList.add(new DashboardItem(getResources().getString(R.string.service_redirection),getResources().getString(R.string.service_redirection_description),getResources().getString(R.string.service_redirection_action),R.drawable.redirection));

        adapter = new ServicesAdapter(getApplicationContext(),servicesList);
        recyclerView.setAdapter(adapter);
    }
}
