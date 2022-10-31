package com.example.sabpham_sqline;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sabpham_sqline.Data.DBMannager;
import com.example.sabpham_sqline.Model.Sanpham;

public class MainActivity extends AppCompatActivity {

    private EditText edtTensanpham;
    private EditText edtmota;
    private EditText edtsoluong;
    private EditText edtgiatien;
    private Button btnSave;
    private ListView lvSanpham;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //khởi tạo đối tượng Manager
        final DBMannager dbMannager = new DBMannager(this);
        edtTensanpham= (EditText) findViewById(R.id.edt_tensanpham);
        edtmota = (EditText) findViewById(R.id.edt_mota);
        edtsoluong=(EditText) findViewById(R.id.edt_soluong);
        edtsoluong=(EditText) findViewById(R.id.edt_giatien);
        btnSave=(Button) findViewById(R.id.button_save);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sanpham sanpham = createSanpham();
                if (sanpham != null) {
                    dbMannager.addSanpham(sanpham);
                }

            }
        });




    }
    private Sanpham createSanpham(){
        String tensanpham = edtTensanpham.getText().toString();
        String mota = edtmota.getText().toString();
        String soluong = edtsoluong.getText().toString();
        String giatien = edtgiatien.getText().toString();

        Sanpham sanpham = new Sanpham(tensanpham,mota,soluong,giatien);
        return sanpham;
    }
}