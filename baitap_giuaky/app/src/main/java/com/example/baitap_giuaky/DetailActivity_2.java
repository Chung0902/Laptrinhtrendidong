package com.example.baitap_giuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        TextView textView = findViewById(R.id.textView4);
        ImageView imageView = findViewById(R.id.imageView7);
        TextView textView_1 = findViewById(R.id.textView5);
        TextView textView_2 = findViewById(R.id.textView6);
        TextView textView_3 = findViewById(R.id.textView7);
        TextView textView_4 = findViewById(R.id.textView8);
        Button button = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}