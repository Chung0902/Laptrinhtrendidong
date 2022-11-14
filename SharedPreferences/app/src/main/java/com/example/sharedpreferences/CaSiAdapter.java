package com.example.sharedpreferences;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CaSiAdapter extends BaseAdapter {
    private Context context;
    private int Layout;
    private List<Casi> casiList;

    public CaSiAdapter(Context context, int layout, List<Casi> casiList) {
        this.context = context;
        Layout = layout;
        this.casiList = casiList;
    }

    @Override
    public int getCount() {
        return casiList.size();//trả về tất cả ca sĩ
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
        TextView txtNghedanh = (TextView) view.findViewById(R.id.textviewNghedanh);
        TextView txtQuocgia = (TextView) view.findViewById(R.id.textViewQuocgia);
        TextView txtSosao = (TextView) view.findViewById(R.id.textViewSosao);
        ImageView imgHinh = (ImageView) view.findViewById(R.id.imageviewHinh);

        //gán giá trị
        Casi caSy = casiList.get(i);

        txtTen.setText(caSy.getTen());
        txtNghedanh.setText(caSy.getNghedanh());
        txtQuocgia.setText(caSy.getQuocgia());
        txtSosao.setText(caSy.getSosao());
        imgHinh.setImageResource(caSy.getHinh());

        return view;
    }
}
