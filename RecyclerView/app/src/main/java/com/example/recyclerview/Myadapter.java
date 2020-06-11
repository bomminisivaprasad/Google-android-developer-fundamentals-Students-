package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {
    MainActivity context;
    int img[];
    String name[];
    public Myadapter(MainActivity mainActivity, int[] image, String[] data) {
        this.context=mainActivity;
        this.img=image;
        this.name=data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(context).inflate(R.layout.row,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
     holder.i.setImageResource(img[position]);
     holder.tv.setText(name[position]);
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView i;
        TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            i=itemView.findViewById(R.id.image_view);
            tv=itemView.findViewById(R.id.text_view);

        }
    }
}
