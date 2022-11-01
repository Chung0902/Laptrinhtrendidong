package com.example.baitap_giuaky.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.baitap_giuaky.R;
import com.google.android.material.navigation.NavigationView;

public class HomepageActivity extends AppCompatActivity {

    private Button btnLogin;

    private Button btnProfile;

    private Button bntListview;

    private Button btnLvdesign;

    private Button btnCanner;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);



        btnLogin = (Button) findViewById(R.id.bntLoginn);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnProfile = (Button) findViewById(R.id.bntProfile);

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        bntListview = (Button) findViewById(R.id.bntListview);

        bntListview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });

        btnLvdesign = (Button) findViewById(R.id.bntlvdesign);

        btnLvdesign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, SQLite_Activity.class);
                startActivity(intent);
            }
        });

        btnCanner = (Button) findViewById(R.id.bntcanner);

        btnCanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomepageActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });




        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.menu_Open,R.string.close_menu);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                    {
                        //Toast.makeText(HomepageActivity.this, "Home Selected", Toast.LENGTH_SHORT).show();
                        Log.i("HomepageActivity", "Home Selected");
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    }
                    case R.id.nav_list:
                    {
                        doOpenlistview();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    }
                    case R.id.nav_profile:
                    {
                        doOpenprofile();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    }
                    case R.id.nav_logout:
                    {
                        doOpenmain();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    }

                }
                return false;
            }
        });

    }

    private void doOpenprofile(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    private void doOpenlistview(){
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }

    private void doOpenmain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }


    }


}
