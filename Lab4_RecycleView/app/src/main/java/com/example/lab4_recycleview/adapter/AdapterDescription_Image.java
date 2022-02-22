package com.example.lab4_recycleview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab4_recycleview.R;
import com.example.lab4_recycleview.model.Description_Image;

import java.util.ArrayList;

public class AdapterDescription_Image extends RecyclerView.Adapter<AdapterDescription_Image.CustomViewHolder>{
    private ArrayList<Description_Image> arr ;

    public AdapterDescription_Image(ArrayList<Description_Image> arr) {
        this.arr = arr;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview,parent,false);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Description_Image des = arr.get(position);
        if(des == null){
            return;
        }
        holder.txt_view.setText(des.getDescription());
        holder.img_view.setImageResource(des.getSrc_img());
    }

    @Override
    public int getItemCount() {
        if(arr != null){
            return arr.size();
        }
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_view;
        private TextView txt_view;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            img_view = itemView.findViewById(R.id.img_picture);
            txt_view = itemView.findViewById(R.id.txt_paragrap);
        }
    }
}
