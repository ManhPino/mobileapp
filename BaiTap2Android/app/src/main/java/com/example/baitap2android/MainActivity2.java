package com.example.baitap2android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private Button btnCancel, btnLogin;
    private EditText txt_name,txt_pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnLogin = findViewById(R.id.btn_login);
        btnCancel = findViewById(R.id.btnCancel_login);
        txt_name = findViewById(R.id.txt_name_login);
        txt_pass = findViewById(R.id.txt_pass_login);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = txt_name.getText().toString();
                String pass = txt_pass.getText().toString();
                if(MainActivity.data != null){
                    for(int i = 0; i < MainActivity.data.size() ; i++){
                        if(MainActivity.data.get(i).getUsername().equals(user) && MainActivity.data.get(i).getPassword().equals(pass)){
                            Intent intent = new Intent(MainActivity2.this, Wellcome.class);
                            startActivity(intent);
                            finish();
                            break;
                        }
                    }
                }else{
                    Toast.makeText(MainActivity2.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}