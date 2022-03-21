package com.example.smartphonestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.smartphonestore.database.ConnectDB;
import com.example.smartphonestore.model.Product;

public class SmartPhoneEditor extends AppCompatActivity {
private ConnectDB database;
private EditText edtname,edtlink,edtdes,edtprice;
private Button btnEdit,btnCancel;
private Product p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_phone_editor);
        database = new ConnectDB(this,"SmartPhoneStore.sqlite",null,1);
        AnhXa();
        getData();
        updateDatabase();
    }
    public void getData(){
        Bundle bundle = getIntent().getExtras();
        p = (Product) bundle.getSerializable("infor");
        edtname.setText(p.getTensp());
        edtdes.setText(p.getDes());
        edtprice.setText(p.getPrice());
        edtlink.setText(p.getLink());
    }
    public void updateDatabase(){
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtname.getText().toString();
                String des =  edtdes.getText().toString();
                String price = edtprice.getText().toString();
                String link = edtlink.getText().toString();
                database.update_database(name,des,price,link,p.getId());
                MainActivity.productArrayList.clear();
                MainActivity.customAdapterRecycleView.notifyDataSetChanged();
                MainActivity.displayData();
                Toast.makeText(getApplicationContext(), "Sửa thành công", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
    public void AnhXa(){
      edtname = findViewById(R.id.edt_namephone);
      edtdes = findViewById(R.id.edt_des);
      edtlink = findViewById(R.id.edt_linkphone);
      edtprice = findViewById(R.id.edt_price);
      btnEdit = findViewById(R.id.btnEdit);
      btnCancel = findViewById(R.id.btnCancel_Edit);
    }
}