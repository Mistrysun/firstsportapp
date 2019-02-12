package com.example.android.firstsportapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usernameEditText;
    EditText passwordEditText;
    ImageView logoImageView;
    Button loginButton;

    @Override
    public void onBackPressed() {

    }

    public void loginFunction(View view) {

        if (TextUtils.isEmpty(usernameEditText.getText().toString()) || TextUtils.isEmpty(passwordEditText.getText().toString())){
            Toast toast = Toast.makeText(this, "Wrong Username or Password \n                Please try again!", Toast.LENGTH_LONG);
            toast.show();
        } else {

            Log.i("username", usernameEditText.getText().toString());
            Log.i("Password", passwordEditText.getText().toString());
            Log.i("Info", "Successful");

            OpenLoginActivity();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        logoImageView = (ImageView) findViewById(R.id.logoImageView);
        loginButton = (Button) findViewById(R.id.loginButton);

        //Clearing object off screen
        logoImageView.setY(-1000);
        usernameEditText.setY(1200);
        passwordEditText.setY(1200);
        loginButton.setY(1200);

        //Bringing objects on screen
        logoImageView.animate().translationYBy(1000).setDuration(1000);
        usernameEditText.animate().translationYBy(-1200).setDuration(1000);
        passwordEditText.animate().translationYBy(-1200).setDuration(1000);
        loginButton.animate().translationYBy(-1200).setDuration(1000);

    }

    public void OpenLoginActivity() {

        logoImageView.animate().alpha(0).translationYBy(-1000).setDuration(1200);
        usernameEditText.animate().translationYBy(1200).setDuration(1200);
        passwordEditText.animate().translationYBy(1200).setDuration(1200);
        loginButton.animate().translationYBy(1200).setDuration(1200);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent OnClickOperation = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(OnClickOperation);
                finish();
            }
        }, 900);

        EditText usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        Toast.makeText(this, "Signed in as " + usernameEditText.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
