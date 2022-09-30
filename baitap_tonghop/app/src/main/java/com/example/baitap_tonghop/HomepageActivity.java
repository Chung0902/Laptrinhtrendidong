package com.example.baitap_tonghop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomepageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        Button btnLogin = findViewById(R.id.buttonlogin);

        btnLogin.setOnClickListener(view -> {
            Intent intent = new Intent(HomepageActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        Button btnProfile = findViewById(R.id.buttonprofile);

        btnProfile.setOnClickListener(view -> {
            Intent intent = new Intent(HomepageActivity.this, MainActivity.class);
            startActivity(intent);
        });

        Button bntList = findViewById(R.id.buttonlist);

        bntList.setOnClickListener(view -> {
            Intent intent = new Intent(HomepageActivity.this, ListViewActivity.class);
            startActivity(intent);
        });

    }
}