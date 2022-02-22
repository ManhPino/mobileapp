package com.example.lab4_recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.lab4_recycleview.adapter.AdapterDescription_Image;
import com.example.lab4_recycleview.model.Description_Image;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private AdapterDescription_Image adapterDescription_image;
    private ArrayList<Description_Image> arrayList ;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcv_list);
        arrayList = new ArrayList<>();
        arrayList.add(new Description_Image(R.drawable.sky,"This is blue sky"));
        arrayList.add(new Description_Image(R.drawable.sky,"This is blue sky"));
        arrayList.add(new Description_Image(R.drawable.sky,"This is blue sky"));
        arrayList.add(new Description_Image(R.drawable.sky,"This is blue sky"));

        adapterDescription_image = new AdapterDescription_Image(arrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapterDescription_image);
    }
}