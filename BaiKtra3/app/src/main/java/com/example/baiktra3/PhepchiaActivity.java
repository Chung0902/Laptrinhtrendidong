package com.example.baiktra3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PhepchiaActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnTroVe;
    private EditText number1, number2;
    private TextView txtketqua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phepchia);
        btnTroVe = (Button) findViewById(R.id.buttonTrove);
        number1 = (EditText) findViewById(R.id.editTextText1);
        number2 = (EditText) findViewById(R.id.editTextText2);
        txtketqua = (TextView) findViewById(R.id.txtkq);

        findViewById(R.id.buttonTinh).setOnClickListener(this);

        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhepchiaActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        int num1 = Integer.parseInt(number1.getText().toString());
        int num2 = Integer.parseInt(number2.getText().toString());
        int result = 0;
        switch (view.getId()){
            case R.id.buttonTinh:
                result = num1 / num2;
                break;
        }
        txtketqua.setText(result);
    }
}