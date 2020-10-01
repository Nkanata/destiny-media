package com.example.busiaonestop;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.busiaonestop.ui.login.Constants;

import java.util.HashMap;
import java.util.Map;

public class Payment extends AppCompatActivity {

ActionBar actionBar;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Toast.makeText(getApplicationContext()," sent wait for notification ",Toast.LENGTH_SHORT).show();

        actionBar = getSupportActionBar();
        actionBar.setTitle("Payment");


        final EditText pay = findViewById(R.id.paydescri);
        submit = findViewById(R.id.submitpay);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send(pay.getText().toString().trim());
            }
        });


    }
    private void send(final String payment){
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.OPS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("done")) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("op", "Payment");
                params.put("user", "1");
                params.put("payment", payment);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }

}
