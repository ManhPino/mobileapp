package com.example.smartphonestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.smartphonestore.adapter.CustomAdapterRecycleView;
import com.example.smartphonestore.database.ConnectDB;
import com.example.smartphonestore.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
public static ArrayList<Product> productArrayList;
private RecyclerView recyclerView ;
public static CustomAdapterRecycleView customAdapterRecycleView;
public static ConnectDB database;
private ImageButton imgbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        productArrayList = new ArrayList<>();
        database = new ConnectDB(this,"SmartPhoneStore.sqlite",null,1);
        database.createTable();        AnhXa();
        displayData();
        setupForRecycleView();
    }
    public void AnhXa(){
        imgbtn = findViewById(R.id.additionPhone);
        recyclerView = findViewById(R.id.recycleview);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SmartPhoneAdditon.class);
                startActivity(intent);
            }
        });
    }
    public void setupForRecycleView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        customAdapterRecycleView = new CustomAdapterRecycleView(productArrayList, MainActivity.this, new IClickOnListener() {
            @Override
            public void ICLickDelete(Product p) {
                database.deletedata_into_databse(p.getId());
                Toast.makeText(MainActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                productArrayList.clear();
                customAdapterRecycleView.notifyDataSetChanged();
                displayData();
            }

            @Override
            public void IClickEdit(Product p) {
                Intent intent = new Intent(MainActivity.this,SmartPhoneEditor.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("infor",p);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(customAdapterRecycleView);
    }
    public static void displayData(){
        String query = "SELECT * FROM SmartPhoneStore";
        Cursor cursor = database.getData(query);
        if(cursor != null){
            while (cursor.moveToNext()){
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String des = cursor.getString(2);
                String link = cursor.getString(3);
                String price = cursor.getString(4);
                productArrayList.add(new Product(id,name,des,link,price));
            }
        }else {
            return;
        }
    }
}