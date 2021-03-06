package com.example.smartphonestore.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.smartphonestore.IClickOnListener;
import com.example.smartphonestore.R;
import com.example.smartphonestore.SmartPhoneEditor;
import com.example.smartphonestore.database.ConnectDB;
import com.example.smartphonestore.model.Product;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CustomAdapterRecycleView extends RecyclerView.Adapter<CustomAdapterRecycleView.ViewHolderPhone> {
    private ArrayList<Product> productArrayList;
    private Context context;
    private ConnectDB database;
    private IClickOnListener iClickOnListener;

    public CustomAdapterRecycleView(ArrayList<Product> productArrayList, Context context, IClickOnListener iClickOnListener) {
        this.productArrayList = productArrayList;
        this.context = context;
        this.iClickOnListener = iClickOnListener;
    }

    @NonNull
    @Override
    public ViewHolderPhone onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_phone,parent,false);
        ViewHolderPhone viewHolderPhone = new ViewHolderPhone(view);
        return viewHolderPhone;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPhone holder, int position) {
        Product p = productArrayList.get(position);
        Glide.with(context.getApplicationContext())
                .load(p.getLink())
                .into(holder.img_smartphone);
        holder.txt_namesmartphone.setText(p.getTensp());
        holder.txt_pricesmartphone.setText("Gi??: "+p.getPrice()+" VN??");
        holder.txt_descriptionsmartphone.setText(p.getDes());
        holder.txt_descriptionsmartphone.setMaxLines(2);
        holder.txt_deleteproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iClickOnListener.ICLickDelete(p);
            }
        });
        holder.txt_editproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              iClickOnListener.IClickEdit(p);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productArrayList.size();
    }
    public void release(){
        context = null;
    }
    class ViewHolderPhone extends RecyclerView.ViewHolder{
        private CardView cardView ;
        private ImageView img_smartphone ;
        private TextView txt_namesmartphone;
        private TextView txt_pricesmartphone;
        private TextView txt_descriptionsmartphone,txt_deleteproduct,txt_editproduct;
        public ViewHolderPhone(@NonNull View itemView) {
            super(itemView);
            txt_deleteproduct = itemView.findViewById(R.id.txt_deleteproduct);
            txt_editproduct = itemView.findViewById(R.id.txt_editproduct);
            cardView = itemView.findViewById(R.id.cardView_smartphone);
            img_smartphone = itemView.findViewById(R.id.imageSmartphone);
            txt_namesmartphone = itemView.findViewById(R.id.txt_product_nameSmartphone);
            txt_pricesmartphone = itemView.findViewById(R.id.txt_product_priceSmartphone);
            txt_descriptionsmartphone = itemView.findViewById(R.id.txt_product_descriptionSmartphone);
        }
    }
}
