package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bntXacNhan;
    EditText edtUsername, edtPassword;
    CheckBox cbRemember;

    SharedPreferences sharedPreferences;
    private Button btnDangnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();

        sharedPreferences = getSharedPreferences("dataLogin",MODE_PRIVATE);

        //Lấy giá trị

        edtUsername.setText(sharedPreferences.getString("taikhoan", ""));
        edtPassword.setText(sharedPreferences.getString("matkhau", ""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));



        bntXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if(username.equals("nguyenthichung") && password.equals("1234")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    //Nếu có check
                    if(cbRemember.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("taikhoan", username);
                        editor.putString("matkhau", password);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    }else{
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Lỗi đăng nhập!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDangnhap = (Button) findViewById(R.id.buttonXacnhan);

        btnDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(intent);
            }
        });

    }

    private void AnhXa(){
        bntXacNhan = (Button) findViewById(R.id.buttonXacnhan);
        edtUsername = (EditText) findViewById(R.id.edtusername);
        edtPassword =(EditText) findViewById(R.id.edtpassword);
        cbRemember = (CheckBox) findViewById(R.id.checkBoxnhodangnhap);

    }
}