package com.example.csdl_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.csdl_sqlite.model.Employee;
import com.example.csdl_sqlite.sqlite.EmployeeDao;

public class AddOrEditEmployeeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etEmployeeId, etName, etDiem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_or_edit_employee);

        etEmployeeId = findViewById(R.id.etid1);
        etName = findViewById(R.id.etname);
        etDiem = findViewById(R.id.etdiem);

        findViewById(R.id.btnsave).setOnClickListener(this);
        findViewById(R.id.btnlistempoylee).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnsave:
                EmployeeDao dao = new EmployeeDao(this);
                Employee emp = new Employee();

                emp.setId(etEmployeeId.getText().toString());
                emp.setName(etName.getText().toString());
                emp.setDiem(Float.parseFloat(etDiem.getText().toString()));

                dao.insert(emp);
                Toast.makeText(this, "New employee has been saved!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}