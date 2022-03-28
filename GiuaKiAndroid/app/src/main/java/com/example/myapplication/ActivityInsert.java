package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.database.Database;

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
                database.insert_into_database(name,email,contact,address);
                MainActivity.infor.clear();
                MainActivity.inforAdapter.notifyDataSetChanged();
                MainActivity.displayData();
                finish();
            }
        });
    }
}