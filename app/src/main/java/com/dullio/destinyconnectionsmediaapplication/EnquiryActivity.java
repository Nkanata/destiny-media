package com.dullio.destinyconnectionsmediaapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EnquiryActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ActionBar actionBar;
    private RecyclerView recyclerView;
    private EditText editText;
    private ImageView imageView;
    private String message;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;
    private List<Message> messages;
    private LinearLayout emptyView;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.enquiries_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.navigation_clear_enquiries){
            messages = null;
            adapter.notifyDataSetChanged();
            checkDataset();
            return true;
        }

        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiry);

        toolbar = findViewById(R.id.enquiry_toolbar);
        editText = findViewById(R.id.enquiry_message);
        imageView = findViewById(R.id.enquiry_sendImage);
        recyclerView = findViewById(R.id.enquiries_recyclerView);
        emptyView = findViewById(R.id.empty_enquiry);
        manager = new LinearLayoutManager(getApplicationContext());

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.enquiry_module));
        actionBar.setDisplayHomeAsUpEnabled(true);

        recyclerView.setLayoutManager(manager);
       // checkDataset();

        adapter = new MessagesRecyclerAdapter(getApplicationContext(),messages);
        recyclerView.setAdapter(adapter);

        imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_send));
        imageView.setOnClickListener(new View.OnClickListener() {
            @java.lang.Override
            public void onClick(View view) {
                if (editText.getText().toString() != null){

                    messages = new ArrayList<>();
                    messages.add(new Message(editText.getText().toString(),true));
                    reply();
                    adapter.notifyDataSetChanged();
                    editText.setText("");
                    editText.setHint(getResources().getString(R.string.enquiry_hint));
                    checkDataset();
                }



            }
        });
    }

    private void checkDataset (){
        if (messages == null){
            recyclerView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        }
        else{
            recyclerView.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }
    }

    private void reply(){
        messages.add(new Message("Thanks for the enquiry, you will get a response very soon. Keep checking your notifications.",false));
        adapter.notifyDataSetChanged();
    }


}
