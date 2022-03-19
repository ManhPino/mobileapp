package com.example.apptriva_lab4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_gameover#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment_gameover extends Fragment {
private Button btnBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gameover, container, false);
        btnBack = view.findViewById(R.id.backHome);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new fragment_question());
            }
        });
        return view;
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();
    }
}