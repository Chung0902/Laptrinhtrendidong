package com.example.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter {
    private List mStudents;

    private Context mContext;

    public StudentAdapter(List mStudents, Context mContext) {
        this.mStudents = mStudents;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View studentView = inflater.inflate(R.layout.student_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(studentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Student student = (Student) mStudents.get(position);

        holder.mName.setText(student.getmName());
        holder.birthYear.setText(student.getBirthYear()+"");

    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }
}
