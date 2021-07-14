package com.example.chapter3.homework;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private List<TestData> mDataset = new ArrayList<>();

    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_item, parent, false));
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvMes;
        private ImageView tvImg;
        private View contentView;


        public MyViewHolder(View v) {
            super(v);
            contentView = v;
            tvImg = v.findViewById(R.id.tv_img);
            tvName = v.findViewById(R.id.tv_name);
            tvMes = v.findViewById(R.id.tv_mes);
        }

        public void onBind(int position, TestData data) {
            if (position % 4 == 0)
                tvImg.setImageResource(R.drawable.head1);
            else if (position % 4 == 1)
                tvImg.setImageResource(R.drawable.head2);
            else if (position % 4 == 2)
                tvImg.setImageResource(R.drawable.head3);
            else if (position % 4 == 3)
                tvImg.setImageResource(R.drawable.head4);
            tvName.setText(data.name);
            tvMes.setText(data.mes);
        }

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.onBind(position, mDataset.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public MyAdapter(List<TestData> myDataset) {
        mDataset.addAll(myDataset);
    }
}
