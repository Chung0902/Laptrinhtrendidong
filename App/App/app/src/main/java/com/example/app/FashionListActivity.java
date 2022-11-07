package com.example.app;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class FashionListActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion_list);


        mRecyclerView=(RecyclerView) findViewById(R.id.recycler_fashions);
        new FireBaseDatabaseHelper().readFashions(new FireBaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Fashion> fashions, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView,FashionListActivity.this,fashions,keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        Toast.makeText(FashionListActivity.this, "Farovite", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_farovite:
                        Intent intent=new Intent(FashionListActivity.this,HomeActivity.class);
                        startActivity(intent);
                        Toast.makeText(FashionListActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_profile:
                        Intent intent1=new Intent(FashionListActivity.this,Profile_Activity.class);
                        startActivity(intent1);
                        Toast.makeText(FashionListActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.new_fashion:
                        Intent intent3=new Intent(FashionListActivity.this,NewFashionActivity.class);
                        startActivity(intent3);
                        Toast.makeText(FashionListActivity.this, "New Fashion", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}

