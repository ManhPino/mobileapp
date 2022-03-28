package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.database.Database;
import com.example.myapplication.model.Infor;

public class ActivityUpdate extends AppCompatActivity {
    Infor f;
    private Database database ;
    private EditText name,email,contact,address;
    private Button btnUpdate, btnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        database = new Database(this,"Information.sqlite",null,1);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            f = (Infor) bundle.getSerializable("infor");
            name = findViewById(R.id.name_update);
            email = findViewById(R.id.email_update);
            contact = findViewById(R.id.contact_update);
            address = findViewById(R.id.address_update);
            btnUpdate = findViewById(R.id.btnUpdate);
            name.setText(f.getName());
            email.setText(f.getEmail());
            contact.setText(f.getContact());
            address.setText(f.getAddress());
        }else{
            return;
        }



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.update_database(name.getText().toString() , email.getText().toString(), contact.getText().toString() , address.getText().toString() , f.getId());
                MainActivity.infor.clear();
                MainActivity.inforAdapter.notifyDataSetChanged();
                MainActivity.displayData();
                finish();
            }
        });

    }
}