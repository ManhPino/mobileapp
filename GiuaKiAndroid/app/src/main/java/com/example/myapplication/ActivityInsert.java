package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.api.RetrofitConfig;
import com.example.myapplication.database.Database;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivityInsert extends AppCompatActivity {
    public EditText mName,mEmail,mContact,mAddress;
    private Button insert ;
    private Database database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        mName = findViewById(R.id.name_update);
        mEmail = findViewById(R.id.email_update);
        mContact = findViewById(R.id.contact_update);
        mAddress = findViewById(R.id.address_update);
        insert = findViewById(R.id.btnUpdate);
        database = new Database(this,"Information.sqlite",null,1);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mName.getText().toString();
                String email = mEmail.getText().toString();
                String contact =mContact.getText().toString();
                String address = mAddress.getText().toString();
                RetrofitConfig.retrofit.insert_infor(name,email,contact,address).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
                MainActivity.inforAdapter.notifyDataSetChanged();
                new MainActivity().displayData();
                finish();
            }
        });
    }
}