package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private ImageView imgClick;
private TextView txtAmount, txtTotal;
private int totalClick = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
    }
    private void anhXa(){
      imgClick = findViewById(R.id.btn_img);
      txtAmount = findViewById(R.id.txt_amout);
      txtTotal = findViewById(R.id.txt_total);
      imgClick.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              int i = 0;
              int check = dessertArrayList().get(i).getStartProductionAmount();
              if(totalClick <= 10){
                  imgClick.setImageResource(dessertArrayList().get(i).getImgID());
              }else if(totalClick <= 20 && totalClick >10){
                  Toast.makeText(MainActivity.this, "10 & 20", Toast.LENGTH_SHORT).show();
                  imgClick.setImageResource(dessertArrayList().get(1).getImgID());
              }else if(totalClick <= 30 && totalClick >20){
                  imgClick.setImageResource(dessertArrayList().get(2).getImgID());
              }
              else if(totalClick <= 40 && totalClick >30){
                  imgClick.setImageResource(dessertArrayList().get(3).getImgID());
              }
              else if(totalClick <= 50 && totalClick >40){
                  imgClick.setImageResource(dessertArrayList().get(4).getImgID());
              }
              else if(totalClick <= 60 && totalClick >50){
                  imgClick.setImageResource(dessertArrayList().get(5).getImgID());
              }
              else if(totalClick <= 70 && totalClick >60){
                  imgClick.setImageResource(dessertArrayList().get(6).getImgID());
              }
              else if(totalClick <= 80 && totalClick >70){
                  imgClick.setImageResource(dessertArrayList().get(7).getImgID());
              }
              else if(totalClick <= 90 && totalClick >80){
                  imgClick.setImageResource(dessertArrayList().get(8).getImgID());
              }
              txtAmount.setText(totalClick+"");
              txtTotal.setText("$"+totalClick * 5);
              totalClick+=1;
          }
      });
    }
    private ArrayList<Dessert> dessertArrayList(){
        ArrayList<Dessert> arrayList = new ArrayList();
        arrayList.add(new Dessert(R.drawable.cupcake,5,10));
        arrayList.add(new Dessert(R.drawable.donut,5,20));
        arrayList.add(new Dessert(R.drawable.eclair,5,30));
        arrayList.add(new Dessert(R.drawable.froyo,5,40));
        arrayList.add(new Dessert(R.drawable.kitkat,5,50));
        arrayList.add(new Dessert(R.drawable.lollipop,5,60));
        arrayList.add(new Dessert(R.drawable.marshmallow,5,70));
        arrayList.add(new Dessert(R.drawable.nougat,5,80));
        arrayList.add(new Dessert(R.drawable.oreo,5,90));
        return arrayList;
    }
}