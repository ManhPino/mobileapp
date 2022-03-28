package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.adapter.InforAdapter;
import com.example.myapplication.database.Database;
import com.example.myapplication.model.Infor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Infor> infor;
    public static InforAdapter inforAdapter;
    public static Database database;
    public static RecyclerView rcv ;
    public Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        infor = new ArrayList<>();
        database = new Database(this,"Information.sqlite",null,1);
        database.createTable();
        rcv = findViewById(R.id.rcv_main);
        setUpRecycleView();
        displayData();
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ActivityInsert.class);
                startActivity(intent);
            }
        });
    }
    public void setUpRecycleView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        inforAdapter = new InforAdapter(new IClick() {
            @Override
            public void mDelete(Infor f) {
                 database.deletedata_into_databse(f.getId());
                 Toast.makeText(MainActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                 infor.clear();
                 inforAdapter.notifyDataSetChanged();
                 displayData();
            }

            @Override
            public void mEdit(Infor f) {
                  Intent intent = new Intent(MainActivity.this,ActivityUpdate.class);
                  Bundle bundle = new Bundle();
                  bundle.putSerializable("infor",f);
                  intent.putExtras(bundle);
                  startActivity(intent);
            }
        },infor);
        rcv.setAdapter(inforAdapter);
        rcv.setLayoutManager(linearLayoutManager);
    }
    public static void displayData(){
        String query = "SELECT * FROM Information";
        Cursor cursor = database.getData(query);
        if(cursor != null){
            while (cursor.moveToNext()){
                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String des = cursor.getString(2);
                String link = cursor.getString(3);
                String price = cursor.getString(4);
                infor.add(new Infor(id,name,des,link,price));
            }
        }else {
            return;
        }
    }
}