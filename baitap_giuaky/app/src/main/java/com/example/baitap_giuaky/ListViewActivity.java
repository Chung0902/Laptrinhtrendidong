package com.example.baitap_giuaky;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView lvDienThoai;
    ArrayList<DienThoai> arrayDienThoai;
    DienThoaiAdapter adapter;

    private Button btnTroVe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        AnhXa();

        adapter = new DienThoaiAdapter(this, R.layout.dong_dien_thoai, arrayDienThoai);
        lvDienThoai.setAdapter(adapter);



        lvDienThoai.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    Intent intent = new Intent();
                    intent.setClass(ListViewActivity.this, DetailActivity.class);
                    startActivity(intent);
                }
                if(i==1){
                    Intent intent = new Intent();
                    intent.setClass(ListViewActivity.this, DetailActivity_1.class);
                    startActivity(intent);
                }
                if(i==2){
                    Intent intent = new Intent();
                    intent.setClass(ListViewActivity.this, DetailActivity_2.class);
                    startActivity(intent);
                }
                if(i==3){
                    Intent intent = new Intent();
                    intent.setClass(ListViewActivity.this, DetailActivity_3.class);
                    startActivity(intent);
                }
                if(i==4){
                    Intent intent = new Intent();
                    intent.setClass(ListViewActivity.this, DetailActivity_4.class);
                    startActivity(intent);
                }
            }
        });


        lvDienThoai.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                XacNhanXoa(i);

                return false;
            }
        });

        btnTroVe = (Button) findViewById(R.id.buttontve);

        btnTroVe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListViewActivity.this, HomepageActivity.class);
                startActivity(intent);
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

    /*public void doOpenMainActivity2()
    {
        Intent myIntent;
        myIntent = new Intent( this, DetailActivity.class);
        startActivity(myIntent);
    }*/

    private void AnhXa(){
        lvDienThoai = (ListView) findViewById(R.id.listviewDienThoai);
        arrayDienThoai = new ArrayList<>();

        arrayDienThoai.add(new DienThoai("Iphone", "Iphone 12 Promax", R.drawable.iphone12promax));
        arrayDienThoai.add(new DienThoai("Oppo", "Oppo reno 3", R.drawable.opporeno3));
        arrayDienThoai.add(new DienThoai("Samsung", "Samsung galaxy a32", R.drawable.samsunggalaxya32));
        arrayDienThoai.add(new DienThoai("Xiaomi", "Xiaomi mi 9", R.drawable.xiaomimi9));
        arrayDienThoai.add(new DienThoai("Redmi", "Redmi note 10", R.drawable.xiaomiredminote10));

    }

}