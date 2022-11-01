package com.example.baitap_giuaky.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.baitap_giuaky.R;
import com.example.baitap_giuaky.model.Sanpham;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Sanpham> {

    private Context context;
    private int resource;
    private List<Sanpham> listSanpham;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Sanpham> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.listSanpham=objects;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_list_sanpham,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.tvId=(TextView) convertView.findViewById(R.id.tv_id);
            viewHolder.tvTensanpham=(TextView) convertView.findViewById(R.id.tv_tensanpham);
            viewHolder.tvMota=(TextView) convertView.findViewById(R.id.tv_mota);
            viewHolder.tvSoluong=(TextView) convertView.findViewById(R.id.tv_soluong);
            viewHolder.tvGiatien=(TextView) convertView.findViewById(R.id.tv_giatien);

            convertView.setTag(viewHolder);
        }else{
            viewHolder =(ViewHolder) convertView.getTag();
        }
        Sanpham sanpham = listSanpham.get(position);
        viewHolder.tvId.setText(String.valueOf(sanpham.getmID()));
        viewHolder.tvTensanpham.setText(String.valueOf(sanpham.getmTensanpham()));
        viewHolder.tvMota.setText(String.valueOf(sanpham.getmMota()));
        viewHolder.tvSoluong.setText(String.valueOf(sanpham.getmSoluong()));
        viewHolder.tvGiatien.setText(String.valueOf(sanpham.getmGiatien()));

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
