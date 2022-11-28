package com.example.baiktra3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvPheptinh;
    ArrayList<String> mangPheptinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvPheptinh = (ListView) findViewById(R.id.lvpheptinh);
        mangPheptinh = new ArrayList<String>();

        mangPheptinh.add("Phép cộng");
        mangPheptinh.add("Phép trừ");
        mangPheptinh.add("Phép nhân");
        mangPheptinh.add("Phép chia");
        mangPheptinh.add("Logarit");
        mangPheptinh.add("Chia lấy dư");
        mangPheptinh.add("Chia nguyên");

        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                mangPheptinh
        );

        lvPheptinh.setAdapter(adapter);

        /*lvPheptinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                doOpenCongtrunhanchia();
                Toast.makeText(MainActivity.this, mangPheptinh.get(i)  +  " Vị trí " + i, Toast.LENGTH_SHORT).show();

            }

        });*/

        lvPheptinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, Cong_tru_nhan_chia_Activity.class);
                    startActivity(intent);
                }
                if(i==1){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, PheptruActivity.class);
                    startActivity(intent);
                }
                if(i==2){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, PhepnhanActivity.class);
                    startActivity(intent);
                }
                if(i==3){
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, PhepchiaActivity.class);
                    startActivity(intent);
                }

            }
        });

    }
    public void doOpenCongtrunhanchia()
    {
        Intent myIntent;
        myIntent = new Intent( this, Cong_tru_nhan_chia_Activity.class);
        startActivity(myIntent);
    }
}