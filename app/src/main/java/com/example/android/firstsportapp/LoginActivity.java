package com.example.android.firstsportapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    public void loginFunction(View view) {
        EditText usernameEditText = (EditText) findViewById(R.id.usernameEditText);
        Log.i("username", usernameEditText.getText().toString());

        EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        Log.i("Password", passwordEditText.getText().toString());

        Log.i("Info", "Successful");

        OpenLoginActivity();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView logoImageView = (ImageView) findViewById(R.id.logoImageView);
        logoImageView.setY(-1000);

        logoImageView.animate().translationYBy(1000).setDuration(1000);

    }

    public void OpenLoginActivity() {

        ImageView logoImageView = (ImageView) findViewById(R.id.logoImageView);
        logoImageView.animate().alpha(0).translationYBy(-1000).setDuration(1200);

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
