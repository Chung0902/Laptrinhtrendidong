package com.example.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewHolder extends RecyclerView.ViewHolder {

    private View itemview;
    public TextView studentname;
    public TextView birthyear;
    public Button detail_button;

    public ViewHolder(View itemView) {
        super(itemView);
        itemview = itemView;
        studentname = itemView.findViewById(R.id.studentname);
        birthyear = itemView.findViewById(R.id.birthyear);
        detail_button = itemView.findViewById(R.id.detail_button);

        //Xử lý khi nút Chi tiết được bấm
        detail_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),
                                studentname.getText() +" | "
                                        + " Demo function", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}

