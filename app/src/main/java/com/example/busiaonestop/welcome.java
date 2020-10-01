package com.example.busiaonestop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class welcome extends AppCompatActivity {
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        send = findViewById(R.id.send);
        final EditText entered = findViewById(R.id.entered);
        final EditText left = findViewById(R.id.left);
        final EditText border = findViewById(R.id.border);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guest(entered.getText().toString().trim(), left.getText().toString().trim(),
                        border.getText().toString().trim());
            }
        });

    }

    private void guest(final String entered, final String left, final String border){
        final String url = Constants.OPS_URL;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
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
        }){
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("op", "Guest");
                params.put("user", "1");
                params.put("country_entered", entered);
                params.put("country_left", left);
                params.put("border_name", border);
                final String TAG = "creds";

                //Log.d(TAG, email);
                //Log.d(TAG, password);
                Log.d(TAG, String.valueOf(params));

                return params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }

}
