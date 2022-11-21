package com.example.bktra2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bktra2.Data.DBMannager;
import com.example.bktra2.Data.model.Cayxanh;
import com.example.bktra2.adapter.CustomAdapter;

import java.util.List;

public class SQLite_Activity extends AppCompatActivity {

    private EditText edtTenkhoahoc;
    private EditText edtTenthuonggoi;
    private EditText edtDactinh;
    private EditText edtMaula;
    private EditText edtId;
    private Button btnSave;
    private Button btnUpdate;
    private Button btnDelete;
    private ListView lvCayxanh;
    private DBMannager dbMannager;
    private CustomAdapter customAdapter;
    private List<Cayxanh> cayxanhList;

    private Button btnCanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        //khởi tạo đối tượng Manager
        dbMannager = new DBMannager(this);
        initWidget();
        cayxanhList = dbMannager.getAllCayxanh();
        setAdapter();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cayxanh cayxanh = createCayxanh();
                if (cayxanh != null) {
                    Toast.makeText(SQLite_Activity.this, "Lưu thành công", Toast.LENGTH_SHORT).show();
                    dbMannager.addCayxanh(cayxanh);
                }
                cayxanhList.clear();
                cayxanhList.addAll(dbMannager.getAllCayxanh());
                setAdapter();
            }
        });

        //Bắt sự kiện trong listview
        lvCayxanh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Cayxanh sanpham = cayxanhList.get(position);
                edtId.setText(String.valueOf(sanpham.getmID()));
                edtTenkhoahoc.setText(sanpham.getmTenkhoahoc());
                edtTenthuonggoi.setText(sanpham.getmTenthuonggoi());
                edtDactinh.setText(sanpham.getmDactinh());
                edtMaula.setText(sanpham.getmMaula());
                btnSave.setEnabled(false);
                btnUpdate.setEnabled(true);
                btnDelete.setEnabled(true);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cayxanh cayxanh = new Cayxanh();
                cayxanh.setmID(Integer.parseInt(String.valueOf(edtId.getText())));
                cayxanh.setmTenkhoahoc(edtTenkhoahoc.getText()+"");
                cayxanh.setmTenthuonggoi(edtTenthuonggoi.getText()+"");
                cayxanh.setmDactinh(edtDactinh.getText()+"");
                cayxanh.setmMaula(edtMaula.getText()+"");
                int result = dbMannager.updateCayxanh(cayxanh);
                if(result>0){
                    Toast.makeText(SQLite_Activity.this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                    cayxanhList.clear();
                    cayxanhList.addAll(dbMannager.getAllCayxanh());
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
                Cayxanh cayxanh = new Cayxanh();
                cayxanh.setmID(Integer.parseInt(String.valueOf(edtId.getText())));
                cayxanh.setmTenkhoahoc(edtTenkhoahoc.getText()+"");
                cayxanh.setmTenthuonggoi(edtTenthuonggoi.getText()+"");
                cayxanh.setmDactinh(edtDactinh.getText()+"");
                cayxanh.setmMaula(edtMaula.getText()+"");
                int result = dbMannager.delecteCayxanh(cayxanh.getmID());
                if(result>0){
                    Toast.makeText(SQLite_Activity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    cayxanhList.clear();
                    cayxanhList.addAll(dbMannager.getAllCayxanh());
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
                Intent intent = new Intent(SQLite_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
    private Cayxanh createCayxanh(){
        String tensanpham = edtTenkhoahoc.getText().toString();
        String tenthuonggoi = edtTenthuonggoi.getText().toString();
        String dactinh = edtDactinh.getText().toString();
        String maula = edtMaula.getText().toString();

        Cayxanh cayxanh = new Cayxanh(tensanpham,tenthuonggoi,dactinh,maula);
        return cayxanh;
    }
    private void initWidget(){
        edtId = (EditText) findViewById(R.id.edt_id);
        edtTenkhoahoc = (EditText) findViewById(R.id.edt_tensanpham);
        edtTenthuonggoi = (EditText) findViewById(R.id.edt_mota);
        edtDactinh = (EditText) findViewById(R.id.edt_soluong);
        edtMaula = (EditText) findViewById(R.id.edt_giatien);
        btnSave=(Button) findViewById(R.id.button_save);
        btnUpdate=(Button) findViewById(R.id.button_update);
        btnDelete=(Button) findViewById(R.id.button_delete);
        lvCayxanh = (ListView) findViewById(R.id.lv_sanpham);
    }
    private void setAdapter(){
        if(customAdapter== null){
            customAdapter = new CustomAdapter(this,R.layout.item_list_cayxanh,cayxanhList);
            lvCayxanh.setAdapter(customAdapter);
        }else{
            customAdapter.notifyDataSetChanged();
            //thêm vào cuối cùng trong listview
            lvCayxanh.setSelection(customAdapter.getCount()-1);
        }
    }
}