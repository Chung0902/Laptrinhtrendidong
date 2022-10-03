package com.example.baitap_giuaky;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DienThoaiAdapter extends BaseAdapter {

    private Context context;
    private int Layout;
    private List<DienThoai> dienThoaiList;

    public DienThoaiAdapter(Context context, int layout, List<DienThoai> dienThoaiList) {
        this.context = context;
        Layout = layout;
        this.dienThoaiList = dienThoaiList;
    }

    @Override
    public int getCount() {
        return dienThoaiList.size();//trả về tất cả các đòn điện thoại
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //trả về mỗi dòng trên item

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //view chứa các layout
        view = inflater.inflate(Layout,null);

        //ánh xạ view
        TextView txtTen = (TextView) view.findViewById(R.id.textviewTen);
        TextView txtMota = (TextView) view.findViewById(R.id.textviewMota);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imageviewHinh);

        //gán giá trị
        DienThoai dienThoai = dienThoaiList.get(i);

        txtTen.setText(dienThoai.getTen());
        txtMota.setText(dienThoai.getMoTa());
        imgHinh.setImageResource(dienThoai.getHinh());

        return view;
    }


}
