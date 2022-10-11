package com.example.csdl_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.csdl_sqlite.sqlite.DBHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DBHelper dbHelper = new DBHelper(this);
       // SQLiteDatabase database = dbHelper.getReadableDatabase();
       // database.close();

        findViewById(R.id.btnedit).setOnClickListener(this);
        findViewById(R.id.btndelete).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnedit:
                Intent intent = new Intent(this, AddOrEditEmployeeActivity.class);
                startActivity(intent);
                break;
        }

    }
}