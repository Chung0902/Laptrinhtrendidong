package com.example.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class NewFashionActivity extends AppCompatActivity {
    private EditText mTen_editTxt;
    private EditText mMota_editTxt;
    private EditText mTien_editTxt;
    private Button mAdd_btn;
    private Button mBack_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_fashion);
        mTen_editTxt=(EditText) findViewById(R.id.ten_editTxt);
        mMota_editTxt=(EditText) findViewById(R.id.mota_editTxt);
        mTien_editTxt=(EditText) findViewById(R.id.tien_editTxt);

        mAdd_btn=(Button) findViewById(R.id.uodate_btn);
        mBack_btn=(Button) findViewById(R.id.back_btn);
        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fashion fashion= new Fashion();
                fashion.setTen(mTen_editTxt.getText().toString());
                fashion.setMota(mMota_editTxt.getText().toString());
                fashion.setTien(mTien_editTxt.getText().toString());

                new FireBaseDatabaseHelper().addFashion(fashion, new FireBaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Fashion> fashions, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(NewFashionActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {

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