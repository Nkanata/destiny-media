package com.dullio.destinyconnectionsmediaapplication.ui.login;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import com.dullio.destinyconnectionsmediaapplication.HomeActivity;
import com.dullio.destinyconnectionsmediaapplication.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private TextInputEditText usernameEditText,passwordEditText;
    private Button loginButton,signUpButton;
    private TextView forgotPasswordButton;
    private LinearLayout detailsLayout;
    private  boolean RESULT_OK = false;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.login_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.navigation_sign_up){

            // Intent to open Sign up activity
            return true;
        }

        return false;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        toolbar = findViewById(R.id.login_toolbar);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login);
        forgotPasswordButton = findViewById(R.id.forgot_password_textView);
        signUpButton = findViewById(R.id.sign_up_button);
        detailsLayout = findViewById(R.id.sign_in_details_layout);

        setSupportActionBar(toolbar);
        toolbar.setOverflowIcon(getResources().getDrawable(R.drawable.ic_more_vert_black_24dp));

        actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputEditText [] editTexts = {usernameEditText,passwordEditText};
                String [] keys = {"email","pass"};

                for (int i = 0; i<editTexts.length; i++){
                    validateAndLogIn(editTexts[i],keys[i]);

                }

            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_LONG).show();
    }

    private void setLayoutHighlight(){
        Drawable drawable = getResources().getDrawable(R.drawable.highlight_stroke);
        detailsLayout.setBackgroundDrawable(drawable);
    }

    private void removeLayoutHighlight(){
        detailsLayout.setBackgroundResource(0);
    }


    private void validateAndLogIn(TextInputEditText editText,String key){

        switch (key){

            case "email":

                if (!editText.getText().toString().isEmpty() &&editText.getText().toString().contains("@")){
                    RESULT_OK =true;
                }
                else {
                    editText.setError("Enter a valid email address");
                    RESULT_OK =false;
                }
                break;

            case "pass":

                if (!editText.getText().toString().isEmpty() && editText.getText().toString().trim().length() > 5 ){


                    RESULT_OK =true;
                }
                else {
                    editText.setError("Password must be > 5 characters");
                    RESULT_OK =false;
                }


                break;

                default:


        }

        if (RESULT_OK){
            finish();

            Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
            startActivity(intent);
        }

    }


}