package com.example.csdl_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.csdl_sqlite.Adapter.EmployeeAdapter;
import com.example.csdl_sqlite.model.Employee;
import com.example.csdl_sqlite.sqlite.DBHelper;
import com.example.csdl_sqlite.sqlite.EmployeeDao;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EmployeeAdapter employeeAdapter;
    private ListView lvEmployees;
    private String employeeId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //DBHelper dbHelper = new DBHelper(this);
       // SQLiteDatabase database = dbHelper.getReadableDatabase();
       // database.close();

        findViewById(R.id.btnisnert).setOnClickListener(this);
        findViewById(R.id.btnedit).setOnClickListener(this);
        findViewById(R.id.btndelete).setOnClickListener(this);

        lvEmployees = findViewById(R.id.lvEmployees);
        EmployeeDao dao = new EmployeeDao(this);
        List<Employee> list = dao.getAll();

        employeeAdapter = new EmployeeAdapter(this, list);
        lvEmployees.setAdapter(employeeAdapter);


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, AddOrEditEmployeeActivity.class);
        switch (view.getId()){
            case R.id.btnisnert:

                startActivity(intent);
                break;
            case R.id.btnedit:
                Bundle bundle = new Bundle();
                bundle.putString("id", employeeId);
                intent.putExtra("data", bundle);
                startActivity(intent);
                break;
        }

    }
}