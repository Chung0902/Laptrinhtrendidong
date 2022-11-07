package com.example.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private FashionAdapter mFashionsAdapter;
    public void setConfig(RecyclerView recyclerView, Context context,List<Fashion> fashions,List<String> keys){
        mContext=context;
        mFashionsAdapter=new FashionAdapter(fashions,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mFashionsAdapter);
    }

    class FashionItemView extends RecyclerView.ViewHolder{
        private TextView mTen;
        private TextView mMota;
        private TextView mTien;

        private String key;

        public FashionItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).
                    inflate(R.layout.fashion_list_item,parent,false));

            mTen= (TextView) itemView.findViewById(R.id.textViewTen);
            mMota = (TextView) itemView.findViewById(R.id.textViewMota);
            mTien=(TextView) itemView.findViewById(R.id.textViewTien);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1=new Intent(mContext,Detail_Activity.class);
                    mContext.startActivity(intent1);
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    Intent intent=new Intent(mContext,FashionDetailsActivity.class);
                    intent.putExtra("key",key);
                    intent.putExtra("ten",mTen.getText().toString());
                    intent.putExtra("mota",mMota.getText().toString());
                    intent.putExtra("tien",mTien.getText().toString());

                    mContext.startActivity(intent);
                    return false;
                }
            });
        }
        public void bind(Fashion fashion,String key)
        {
            mTen.setText(fashion.getTen());
            mMota.setText(fashion.getMota());
            mTien.setText(fashion.getTien());
            this.key=key;
        }
    }
    class FashionAdapter extends RecyclerView.Adapter<FashionItemView>{
        private List<Fashion> mFashionList;
        private List<String> mKeys;

        public FashionAdapter(List<Fashion> mFashionList, List<String> mKeys) {
            this.mFashionList = mFashionList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public FashionItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new FashionItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull FashionItemView holder, int position) {
            holder.bind(mFashionList.get(position),mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mFashionList.size();
        }
    }
}
