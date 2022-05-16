package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.api.RetrofitConfig;
import com.example.myapplication.model.Account;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AcitivityRegister extends AppCompatActivity {
    private EditText user_register;
    private EditText pass_register;
    private Button btn_register;
    private TextView txt_move_login;
    public static ArrayList<Account> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acitivity_register);
        getData();
        anhXa();
    }
    private void anhXa(){
        user_register = findViewById(R.id.username_register);
        pass_register = findViewById(R.id.password_register);
        btn_register = findViewById(R.id.btn_register);
        txt_move_login = findViewById(R.id.txt_move_login);
        txt_move_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AcitivityRegister.this,ActivityLogin.class);
                startActivity(intent);
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = user_register.getText().toString();
                String pass = pass_register.getText().toString();
                RetrofitConfig.retrofit.register(user,pass).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.d("111",response.body());
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(AcitivityRegister.this, "Fail", Toast.LENGTH_SHORT).show();
                    }
                });
                getData();
                Intent intent = new Intent(AcitivityRegister.this,ActivityLogin.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void getData(){
        RetrofitConfig.retrofit.login().enqueue(new Callback<ArrayList<Account>>() {
            @Override
            public void onResponse(Call<ArrayList<Account>> call, Response<ArrayList<Account>> response) {
                Toast.makeText(AcitivityRegister.this, "ok", Toast.LENGTH_SHORT).show();
                data = response.body();
            }

            @Override
            public void onFailure(Call<ArrayList<Account>> call, Throwable t) {

            }
        });
    }

}