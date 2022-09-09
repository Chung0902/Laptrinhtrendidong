package com.example.bt_listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView lvMonHoc;
    ArrayList<String> mangMonHoc;
    EditText edtTen;
    Button bntThem, bntCapNhat;

    int vitri = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMonHoc = (ListView) findViewById(R.id.listviewMonHoc);
        mangMonHoc = new ArrayList<String>();
        edtTen = (EditText) findViewById(R.id.editTextTen);
        bntThem = (Button) findViewById(R.id.buttonThem) ;
        bntCapNhat = (Button) findViewById(R.id.buttonCapNhat);

        mangMonHoc.add("Android");
        mangMonHoc.add("JAVA");
        mangMonHoc.add("PHP");
        mangMonHoc.add("Python");
        mangMonHoc.add("Thiết kế web");
        mangMonHoc.add("Quản trị mạng");
        mangMonHoc.add("Lập trình trực quan");

        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                mangMonHoc
        );

        lvMonHoc.setAdapter(adapter);

        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, mangMonHoc.get(i)  +  " Vị trí " + i, Toast.LENGTH_SHORT).show();
            }
        });

        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Bạn chọn " + mangMonHoc.get(i), Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        bntThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edtTen.getText().toString();
                mangMonHoc.add(ten);
                adapter.notifyDataSetChanged();
                edtTen.setText("");
            }
        });

        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtTen.setText(mangMonHoc.get(i));
                vitri = i;
            }
        });

        bntCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t = edtTen.getText().toString();
                mangMonHoc.set(vitri, t);
                adapter.notifyDataSetChanged();
                edtTen.setText("");
            }
        });

        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, " Đã vừa xóa " + mangMonHoc.get(i), Toast.LENGTH_SHORT).show();

                mangMonHoc.remove(i);
                adapter.notifyDataSetChanged();


                return false;
            }
        });

    }
}