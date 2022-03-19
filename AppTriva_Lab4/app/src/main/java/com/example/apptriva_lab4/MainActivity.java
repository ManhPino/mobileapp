package com.example.apptriva_lab4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    public static  Toolbar toolbar ;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        replaceFragment(new fragment_title());
        actionBar();
    }
    private void actionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             drawerLayout.openDrawer(GravityCompat.START);
            }
        });
       navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               int id = item.getItemId();
               if(id == R.id.item_rules){
                   replaceFragment(new fragment_rules());
                   drawerLayout.closeDrawer(GravityCompat.START);
               }else if(id == R.id.item_about){
                   replaceFragment(new fragment_about());
                   drawerLayout.closeDrawer(GravityCompat.START);
               }else if(id == R.id.item_home){
                   replaceFragment(new fragment_title());
                   drawerLayout.closeDrawer(GravityCompat.START);
               }
               return true;
           }
       });
    }
    private void anhxa(){
        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation_view);
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout,fragment);
        transaction.commit();
    }
}