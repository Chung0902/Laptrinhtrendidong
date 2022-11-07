package com.example.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_MainActivity extends AppCompatActivity {
    EditText edtEmail,edtPass;
    Button btnLogin,btnSignup;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_main);
        mAuth=FirebaseAuth.getInstance();

        edtEmail = (EditText) findViewById(R.id.editTextEmail_login);
        edtPass  = (EditText) findViewById(R.id.editTextPassword_login);
        btnSignup= (Button) findViewById(R.id.buttonSignup_login);
        Button btnLogin = findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_MainActivity.this,SignUp_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void login(){
        String email, pass;
        email=edtEmail.getText().toString();
        pass=edtPass.getText().toString();

        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "Vui long nhap Email", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(pass))
        {
            Toast.makeText(this, "Vui long nhap Pass", Toast.LENGTH_SHORT).show();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Login_MainActivity.this, "Dang nhap thanh cong!", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Login_MainActivity.this,FashionListActivity.class);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(Login_MainActivity.this, "Dang nhap khong thanh cong!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
