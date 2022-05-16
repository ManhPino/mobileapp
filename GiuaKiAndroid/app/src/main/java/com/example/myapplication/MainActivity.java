package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.adapter.InforAdapter;
import com.example.myapplication.api.RetrofitConfig;
import com.example.myapplication.database.Database;
import com.example.myapplication.model.Infor;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Infor> infor;
    ArrayList<Infor> information = new ArrayList<>();
    public static InforAdapter inforAdapter;
    public static Database database;
    public static RecyclerView rcv ;
    public Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        displayData();
    }
    public void anhXa(){
        rcv = findViewById(R.id.rcv_main);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ActivityInsert.class);
                startActivity(intent);
            }
        });
    }
    public void setUpRecycleView(ArrayList<Infor> information){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        inforAdapter = new InforAdapter(new IClick() {
            @Override
            public void mDelete(Infor f) {
               if(ActivityLogin.checkrole == true){
                   RetrofitConfig.retrofit.detelte_infor(f.getId()).enqueue(new Callback<String>() {
                       @Override
                       public void onResponse(Call<String> call, Response<String> response) {
                           String data = response.body();
                           Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                           information.clear();
                           inforAdapter.notifyDataSetChanged();
                           displayData();
                       }

                       @Override
                       public void onFailure(Call<String> call, Throwable t) {

                       }
                   });
               }else{
                   Log.d("AAA","Ban khong co quyen xoa");
               }
            }

            @Override
            public void mEdit(Infor f) {
                  if(ActivityLogin.checkrole == true){
                      Intent intent = new Intent(MainActivity.this,ActivityUpdate.class);
                      Bundle bundle = new Bundle();
                      bundle.putSerializable("infor",f);
                      intent.putExtras(bundle);
                      startActivity(intent);
                  }else{
                      Log.d("AAA","Ban khong co quyen xoa");
                  }
            }
        },information);
        rcv.setAdapter(inforAdapter);
        rcv.setLayoutManager(linearLayoutManager);
    }
    public void displayData(){
        RetrofitConfig.retrofit.getinfor().enqueue(new Callback<ArrayList<Infor>>() {
            @Override
            public void onResponse(Call<ArrayList<Infor>> call, Response<ArrayList<Infor>> response) {
                information = response.body();
                setUpRecycleView(information);
            }
            @Override
            public void onFailure(Call<ArrayList<Infor>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Ok bạn ơi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}