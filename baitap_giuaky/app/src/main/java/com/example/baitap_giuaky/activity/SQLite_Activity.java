package com.example.baitap_giuaky.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.baitap_giuaky.R;
import com.example.baitap_giuaky.adapter.CustomAdapter;
import com.example.baitap_giuaky.data.DBMannager;
import com.example.baitap_giuaky.model.Sanpham;

import java.util.List;

public class SQLite_Activity extends AppCompatActivity {

    private EditText edtTensanpham;
    private EditText edtMota;
    private EditText edtSoluong;
    private EditText edtGiatien;
    private EditText edtId;
    private Button btnSave;
    private Button btnUpdate;
    private Button btnDelete;
    private ListView lvSanpham;
    private DBMannager dbMannager;
    private CustomAdapter customAdapter;
    private List<Sanpham> sanphamList;

    private Button btnCanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        //khởi tạo đối tượng Manager
        dbMannager = new DBMannager(this);
        initWidget();
        sanphamList = dbMannager.getAllSanpham();
        setAdapter();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sanpham sanpham = createSanpham();
                if (sanpham != null) {
                    Toast.makeText(SQLite_Activity.this, "Lưu thành công", Toast.LENGTH_SHORT).show();
                    dbMannager.addSanpham(sanpham);
                }
                sanphamList.clear();
                sanphamList.addAll(dbMannager.getAllSanpham());
                setAdapter();
            }
        });

        //Bắt sự kiện trong listview
        lvSanpham.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Sanpham sanpham = sanphamList.get(position);
                edtId.setText(String.valueOf(sanpham.getmID()));
                edtTensanpham.setText(sanpham.getmTensanpham());
                edtMota.setText(sanpham.getmMota());
                edtSoluong.setText(sanpham.getmSoluong());
                edtGiatien.setText(sanpham.getmGiatien());
                btnSave.setEnabled(false);
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sanpham sanpham = new Sanpham();
                sanpham.setmID(Integer.parseInt(String.valueOf(edtId.getText())));
                sanpham.setmTensanpham(edtTensanpham.getText()+"");
                sanpham.setmMota(edtMota.getText()+"");
                sanpham.setmSoluong(edtSoluong.getText()+"");
                sanpham.setmGiatien(edtGiatien.getText()+"");
                int result = dbMannager.updateSanpham(sanpham);
                if(result>0){
                    Toast.makeText(SQLite_Activity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    sanphamList.clear();
                    sanphamList.addAll(dbMannager.getAllSanpham());
                    customAdapter.notifyDataSetChanged();
                    btnSave.setEnabled(true);
                    btnUpdate.setEnabled(false);
                }else{
                    Toast.makeText(SQLite_Activity.this, "Cập nhật không thành công", Toast.LENGTH_SHORT).show();
                    btnSave.setEnabled(true);
                    btnUpdate.setEnabled(false);
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sanpham sanpham = new Sanpham();
                sanpham.setmID(Integer.parseInt(String.valueOf(edtId.getText())));
                sanpham.setmTensanpham(edtTensanpham.getText()+"");
                sanpham.setmMota(edtMota.getText()+"");
                sanpham.setmSoluong(edtSoluong.getText()+"");
                sanpham.setmGiatien(edtGiatien.getText()+"");
                int result = dbMannager.delecteSanpham(sanpham.getmID());
                if(result>0){
                    Toast.makeText(SQLite_Activity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    sanphamList.clear();
                    sanphamList.addAll(dbMannager.getAllSanpham());
                    customAdapter.notifyDataSetChanged();
                    btnSave.setEnabled(true);
                    btnDelete.setEnabled(false);
                    btnUpdate.setEnabled(false);
                }else{
                    Toast.makeText(SQLite_Activity.this, "Xóa không thành công", Toast.LENGTH_SHORT).show();
                    btnSave.setEnabled(true);
                    btnDelete.setEnabled(false);
                    btnUpdate.setEnabled(false);
                }
            }
        });

        btnCanner = (Button) findViewById(R.id.button_canner1);

        btnCanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SQLite_Activity.this, HomepageActivity.class);
                startActivity(intent);
            }
        });

        //Xóa bằng cách longclick

        /*lvSanpham.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
                Sanpham sanpham = sanphamList.get(position);
                int result = dbMannager.delecteSanpham(sanpham.getmID());
                if(result>0){
                    Toast.makeText(MainActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    sanphamList.clear();
                    sanphamList.addAll(dbMannager.getAllSanpham());
                    customAdapter.notifyDataSetChanged();
                }else{
                    Toast.makeText(MainActivity.this, "Xóa không thành công", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });*/

    }
    private Sanpham createSanpham(){
        String tensanpham = edtTensanpham.getText().toString();
        String mota = edtMota.getText().toString();
        String soluong = edtSoluong.getText().toString();
        String giatien = edtGiatien.getText().toString();

        Sanpham sanpham = new Sanpham(tensanpham,mota,soluong,giatien);
        return sanpham;
    }
    private void initWidget(){
        edtId = (EditText) findViewById(R.id.edt_id);
        edtTensanpham = (EditText) findViewById(R.id.edt_tensanpham);
        edtMota = (EditText) findViewById(R.id.edt_mota);
        edtSoluong = (EditText) findViewById(R.id.edt_soluong);
        edtGiatien = (EditText) findViewById(R.id.edt_giatien);
        btnSave=(Button) findViewById(R.id.button_save);
        btnUpdate=(Button) findViewById(R.id.button_update);
        btnDelete=(Button) findViewById(R.id.button_delete);
        lvSanpham = (ListView) findViewById(R.id.lv_sanpham);
    }
    private void setAdapter(){
        if(customAdapter== null){
            customAdapter = new CustomAdapter(this,R.layout.item_list_sanpham,sanphamList);
            lvSanpham.setAdapter(customAdapter);
        }else{
            customAdapter.notifyDataSetChanged();
            //thêm vào cuối cùng trong listview
            lvSanpham.setSelection(customAdapter.getCount()-1);
        }
    }
}