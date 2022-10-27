package com.example.baitap_giuaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    private TextView tvSigup;

    private Button btnLogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.editTextUsername);
        password = (EditText) findViewById(R.id.editTextPass);

        tvSigup = (TextView) findViewById(R.id.textViewSignup);

        DB = new DBHelper(this);

        tvSigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        btnLogin = (Button) findViewById(R.id.bntlogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập tất cả các trường", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "Thông tin không hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}