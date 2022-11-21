package com.example.bktra2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bktra2.Data.model.Cayxanh;
import com.example.bktra2.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Cayxanh> {
    private Context context;
    private int resource;
    private List<Cayxanh> listCayxanh;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Cayxanh> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.listCayxanh=objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_list_cayxanh,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.tvId=(TextView) convertView.findViewById(R.id.tv_id);
            viewHolder.tvTensanpham=(TextView) convertView.findViewById(R.id.tv_tenkhoahoc);
            viewHolder.tvMota=(TextView) convertView.findViewById(R.id.tv_tenthuonggoi);
            viewHolder.tvSoluong=(TextView) convertView.findViewById(R.id.tv_dactinh);
            viewHolder.tvGiatien=(TextView) convertView.findViewById(R.id.tv_maula);

            convertView.setTag(viewHolder);
        }else{
            viewHolder =(ViewHolder) convertView.getTag();
        }
        Cayxanh cayxanh = listCayxanh.get(position);
        viewHolder.tvId.setText(String.valueOf(cayxanh.getmID()));
        viewHolder.tvTensanpham.setText(String.valueOf(cayxanh.getmTenkhoahoc()));
        viewHolder.tvMota.setText(String.valueOf(cayxanh.getmTenthuonggoi()));
        viewHolder.tvSoluong.setText(String.valueOf(cayxanh.getmDactinh()));
        viewHolder.tvGiatien.setText(String.valueOf(cayxanh.getmMaula()));

        return convertView;
    }

    public class ViewHolder{
        private TextView tvId;
        private TextView tvTensanpham;
        private TextView tvMota;
        private TextView tvSoluong;
        private TextView tvGiatien;
    }
}
