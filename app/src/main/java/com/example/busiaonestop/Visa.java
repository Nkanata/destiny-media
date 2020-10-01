package com.example.busiaonestop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
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

public class Visa extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visa);

        //Toast.makeText(getApplicationContext(),"sent wait for notification ",Toast.LENGTH_SHORT).show();

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?

        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.workvisa:
                if (checked)
                    // Pirates are the best
                    send("work visa");
                break;
            case R.id.student:
                if (checked)
                    // Ninjas rule
                    send("student visa");

                break;
            case R.id.visit:
                if (checked)
                    // Ninjas rule
                    send("visit visa");

                break;
        }
    }
    private void send(final String visa){
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
                params.put("op", "Visa");
                params.put("user", "1");
                params.put("visa", visa);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}
