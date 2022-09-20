package com.example.listview_nangcao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class MainActivity<adapter> extends AppCompatActivity {

    ListView lvDienThoai;
    ArrayList<DienThoai> arrayDienThoai;
    DienThoaiAdapter adapter;

    EditText edtTen;
    int vitri = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        adapter = new DienThoaiAdapter(this, R.layout.dong_dien_thoai, arrayDienThoai);
        lvDienThoai.setAdapter(adapter);


        lvDienThoai = (ListView) findViewById(R.id.listviewDienThoai);
        lvDienThoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });



        lvDienThoai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, arrayDienThoai.get(i) + " Vị trí " + i, Toast.LENGTH_SHORT).show();
            }
        });

        lvDienThoai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtTen.setText((CharSequence) arrayDienThoai.get(i));
                vitri = i;
            }
        });


        lvDienThoai.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);

                return false;
            }
        });



    }

    private void XacNhanXoa(final int position){

        AlertDialog.Builder alerDiaLog = new AlertDialog.Builder(this);
        alerDiaLog.setTitle("Thong bao !");
        alerDiaLog.setIcon(R.mipmap.ic_launcher);
        alerDiaLog.setMessage("Bạn có muốn xóa hay không?");

        alerDiaLog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                arrayDienThoai.remove(position);
                adapter.notifyDataSetChanged();

            }
        });
        alerDiaLog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        alerDiaLog.show();
    }



    private void AnhXa(){
        lvDienThoai = (ListView) findViewById(R.id.listviewDienThoai);
        arrayDienThoai = new ArrayList<>();

        arrayDienThoai.add(new DienThoai("Iphone__Nguyễn Thị Chung", "Iphone 12 Promax", R.drawable.iphone12promax));
        arrayDienThoai.add(new DienThoai("Oppo__MSV:2050531200113 ", "Oppo reno 3", R.drawable.opporeno3));
        arrayDienThoai.add(new DienThoai("Samsung", "Samsung galaxy a32", R.drawable.samsunggalaxya32));
        arrayDienThoai.add(new DienThoai("Xiaomi", "Xiaomi mi 9", R.drawable.xiaomimi9));
        arrayDienThoai.add(new DienThoai("Redmi", "Redmi note 10", R.drawable.xiaomiredminote10));

    }



}

