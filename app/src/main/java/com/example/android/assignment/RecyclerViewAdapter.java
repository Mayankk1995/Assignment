package com.example.android.assignment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Mayank on 06-01-2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<Integer> itemList;
    private Context context;

    public RecyclerViewAdapter(Context context,List<Integer> itemList){
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_card,null);
        MyViewHolder myViewHolder = new MyViewHolder(layoutView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.imageView.setImageResource(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ImageView imageView;

    public MyViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        imageView = (ImageView) itemView.findViewById(R.id.image_view);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Position", Toast.LENGTH_SHORT).show();
    }
}
