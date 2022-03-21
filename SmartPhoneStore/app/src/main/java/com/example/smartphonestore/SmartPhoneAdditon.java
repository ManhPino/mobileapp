package com.example.smartphonestore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartphonestore.database.ConnectDB;

public class SmartPhoneAdditon extends AppCompatActivity {
private ConnectDB database;
private EditText addName,addLink,addDes,addPrice;
private Button btnAdd, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_phone_additon);
        database = new ConnectDB(this,"SmartPhoneStore.sqlite",null,1);
        AnhXa();
        addPhone();
    }
    private void addPhone(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=  addName.getText().toString();
                String des = addDes.getText().toString();
                String link = addLink.getText().toString();
                String price = addPrice.getText().toString();
                database.insert_into_database(name,des,link,price);
                Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                MainActivity.productArrayList.clear();
                MainActivity.customAdapterRecycleView.notifyDataSetChanged();
                MainActivity.displayData();
                finish();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void AnhXa(){
      addName = findViewById(R.id.add_namephone);
      addLink = findViewById(R.id.add_linkphone);
      addDes = findViewById(R.id.add_desphone);
      addPrice = findViewById(R.id.add_pricephone);
      btnAdd = findViewById(R.id.btnAdd);
      btnCancel = findViewById(R.id.btnCancel);
    }
}