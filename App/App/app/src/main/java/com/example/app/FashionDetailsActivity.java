package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class FashionDetailsActivity extends AppCompatActivity {

    private EditText mTen_editTxt;
    private EditText mMota_editTxt;
    private EditText mTien_editTxt;

    private Button mUpdate_btn;
    private Button mDelete_btn;
    private Button mBack_btn;

    private String key;
    private String ten;
    private String mota;
    private String tien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion_details);

        key=getIntent().getStringExtra("key");
        ten=getIntent().getStringExtra("ten");
        mota=getIntent().getStringExtra("mota");
        tien=getIntent().getStringExtra("tien");

        mTen_editTxt=(EditText) findViewById(R.id.ten_editTxt);
        mTen_editTxt.setText(ten);
        mMota_editTxt=(EditText) findViewById(R.id.mota_editTxt);
        mMota_editTxt.setText(mota);
        mTien_editTxt=(EditText) findViewById(R.id.tien_editTxt);
        mTien_editTxt.setText(tien);

        mUpdate_btn=(Button) findViewById(R.id.uodate_btn);
        mDelete_btn=(Button) findViewById(R.id.delete_btn);
        mBack_btn=(Button) findViewById(R.id.back_btn);

        mUpdate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fashion fashion=new Fashion();
                fashion.setTen(mTen_editTxt.getText().toString());
                fashion.setMota(mMota_editTxt.getText().toString());
                fashion.setTien(mTien_editTxt.getText().toString());

                new FireBaseDatabaseHelper().updateFashion(key, fashion, new FireBaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Fashion> fashions, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(FashionDetailsActivity.this, "Cập nhật thành công!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });

        mDelete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new FireBaseDatabaseHelper().deleteFashion(key, new FireBaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Fashion> fashions, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {

                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(FashionDetailsActivity.this, "Xóa thành công!", Toast.LENGTH_SHORT).show();
                        finish(); return;
                    }
                });
            }
        });
        mBack_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();return;
            }
        });
    }

}