package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {
    private EditText username_login,password_login;
    private Button btn_login;
    public static boolean checkrole = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhXa();
    }
    private void anhXa(){
     username_login = findViewById(R.id.username_login);
     password_login = findViewById(R.id.password_login);
     btn_login = findViewById(R.id.btn_login);
     btn_login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String user = username_login.getText().toString();
             String pass = password_login.getText().toString();
             if(AcitivityRegister.data != null){
                 for(int i = 0; i < AcitivityRegister.data.size() ; i++){
                     if(AcitivityRegister.data.get(i).getUsername().equals(user) && AcitivityRegister.data.get(i).getPassword().equals(pass)){
                         if(user.equals("admin") && pass.equals("123456789")){
                             checkrole = true;
                         }
                         Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
                         startActivity(intent);
                         finish();
                         break;
                     }
                 }
             }else{
                 Toast.makeText(ActivityLogin.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
             }
         }
     });
    }
}