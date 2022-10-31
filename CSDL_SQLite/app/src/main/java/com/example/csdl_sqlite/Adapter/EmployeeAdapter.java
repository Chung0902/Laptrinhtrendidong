package com.example.csdl_sqlite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.csdl_sqlite.MainActivity;
import com.example.csdl_sqlite.R;
import com.example.csdl_sqlite.model.Employee;

import java.util.List;

public class EmployeeAdapter extends BaseAdapter {

    private Context context;
    private List<Employee>list;


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int iPosition) {
        return list.get(iPosition);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_employee_item, null);
        }

        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvDiem = view.findViewById(R.id.tvDiem);

        Employee emp = list.get(i);
        tvName.setText(emp.getName());
        tvDiem.setText("" + emp.getDiem());
        return view;
    }
}
