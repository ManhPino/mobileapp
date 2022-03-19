package com.example.apptriva_lab4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class fragment_title extends Fragment {

private Button btn ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title, container, false);
        btn = view.findViewById(R.id.btn_play);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new fragment_question());
            }
        });
        return  view ;
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.framelayout,fragment);
        transaction.commit();
    }
}