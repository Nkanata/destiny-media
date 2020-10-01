package com.dullio.destinyconnectionsmediaapplication.ui.login;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dullio.destinyconnectionsmediaapplication.AuthDialogFragment;
import com.dullio.destinyconnectionsmediaapplication.Constants;
import com.dullio.destinyconnectionsmediaapplication.R;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity implements AuthDialogFragment.BottomSheetListener {

    private Toolbar toolbar;
    private ActionBar actionBar;
    private TextInputEditText usernameEditText,emailEditText,nationalIdEditText,phoneEditText,passwordEditText;
    private LinearLayout assistantHighlight;
    private Button registerButton;
    private AuthDialogFragment dialogFragment = new AuthDialogFragment();


    @Override
    public void onDialogDetach(boolean detach, int success) {
        if (detach){
            removeLayoutHighlight();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        toolbar = findViewById(R.id.sign_up_toolbar);
        usernameEditText = findViewById(R.id.sign_up_username);
        emailEditText = findViewById(R.id.sign_up_email);
        nationalIdEditText = findViewById(R.id.sign_up_national_id);
        phoneEditText = findViewById(R.id.sign_up_phone);
        passwordEditText = findViewById(R.id.sign_up_password);
        assistantHighlight = findViewById(R.id.assist_highlight_layout);

        registerButton = findViewById(R.id.sign_up_register_button);

        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registerUser(usernameEditText.getText().toString(),emailEditText.getText().toString(),passwordEditText.getText().toString());
                /**
                final TextInputEditText [] editTexts = {usernameEditText,emailEditText,nationalIdEditText,phoneEditText,passwordEditText};
                String [] keys = {"name","email","id","phone","pass"};
                // Show dialog
                //dialogFragment.setCancelable(false);
                dialogFragment.show(getSupportFragmentManager(),dialogFragment.getTag());

                // Higlight view layout
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setLayoutHighlight();
                    }
                },200);

                for (int i = 0; i< editTexts.length; i++){

                   dialogFragment.validateEditTextDetails(editTexts[i],keys[i],"signUp");
                }
                 **/

            }
        });
    }



    private void registerUser (final String username, final String email, final String password){

        final AuthDialogFragment dialogFragment = new AuthDialogFragment();
        dialogFragment.show(getSupportFragmentManager(),dialogFragment.getTag());

        // Show progress bar;
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        dialogFragment.dismiss();
                        // Hide progress
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            Toast.makeText(getApplicationContext(),jsonObject.getString("message"),Toast.LENGTH_LONG).show();
                        }
                        catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                dialogFragment.dismiss();
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();

                params.put("username",username);
                params.put("email",email);
                params.put("password",password);

                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);


    }


    private void setSelectView(TextInputEditText editText){
        editText.selectAll();
    }

    private void setUnselectedView(TextInputEditText editText){
        editText.setSelected(false);
    }

    private void setLayoutHighlight(){
        Drawable drawable = getResources().getDrawable(R.drawable.highlight_stroke);
        assistantHighlight.setBackgroundDrawable(drawable);
    }

    private void removeLayoutHighlight(){
        assistantHighlight.setBackgroundResource(0);
    }



}
