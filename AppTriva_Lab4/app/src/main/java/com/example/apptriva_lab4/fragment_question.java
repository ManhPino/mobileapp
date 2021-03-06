package com.example.apptriva_lab4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.apptriva_lab4.model.Answers;
import com.example.apptriva_lab4.model.Quetions;

import java.util.ArrayList;


public class fragment_question extends Fragment {
private RadioButton rdo1,rdo2,rdo3,rdo4;
private Button btnSubmit;
private String question ;
private ArrayList<Quetions> arrQuetion;
private TextView txtQuestion;
private boolean isCorrect = false;
private int countQuetions = 0;
private int numberWrong = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View view  = inflater.inflate(R.layout.fragment_question, container, false);
      rdo1 = view.findViewById(R.id.answer_first);
      rdo2 = view.findViewById(R.id.answer_second);
      rdo3 = view.findViewById(R.id.answer_third);
      rdo4 = view.findViewById(R.id.answer_fourth);
      btnSubmit = view.findViewById(R.id.submit);
      txtQuestion = view.findViewById(R.id.txt_question);

        setDataQuetions();

      btnSubmit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              checkCorrect();
          }
      });
      return view ;
    }
    public void checkCorrect(){
        if( initData().get(countQuetions).getAnswer().get(0).isCorrect == true && rdo1.isChecked()){
            countQuetions++;
            setDataQuetions();
        }else{
            numberWrong ++;
        }

        if( initData().get(countQuetions).getAnswer().get(1).isCorrect == true && rdo2.isChecked()){
            countQuetions++;
            setDataQuetions();
        }else{
            numberWrong ++;
        }

        if( initData().get(countQuetions).getAnswer().get(2).isCorrect == true && rdo3.isChecked()){
            countQuetions++;
            setDataQuetions();
        }else{
            numberWrong ++;
        }
        if( initData().get(countQuetions).getAnswer().get(3).isCorrect == true && rdo4.isChecked()){
            countQuetions++;
            setDataQuetions();
        }else{
            numberWrong ++;
        }
        if(numberWrong > 12){
            replaceFragment(new fragment_gameover());
            Toast.makeText(getActivity().getApplicationContext(), "B???n thua", Toast.LENGTH_SHORT).show();
        }
    }
    public void setDataQuetions(){
        if(countQuetions == initData().size()){
            countQuetions = 0;
            Toast.makeText(getActivity().getApplicationContext(), "You win", Toast.LENGTH_SHORT).show();
            replaceFragment(new fragment_won());
        }else {
            txtQuestion.setText("C??u th???"+(countQuetions +1)+":" +initData().get(countQuetions).getQuestion());
            rdo1.setText(initData().get(countQuetions).getAnswer().get(0).getAnswer());
            rdo2.setText(initData().get(countQuetions).getAnswer().get(1).getAnswer());
            rdo3.setText(initData().get(countQuetions).getAnswer().get(2).getAnswer());
            rdo4.setText(initData().get(countQuetions).getAnswer().get(3).getAnswer());
        }
    }
    public ArrayList<Quetions> initData(){
        arrQuetion = new ArrayList<>();

        ArrayList<Answers> arrAnswer0 = new ArrayList<>();
        ArrayList<Answers> arrAnswer1 = new ArrayList<>();
        ArrayList<Answers> arrAnswer2 = new ArrayList<>();

        arrAnswer0.add(new Answers("Ch??",true));
        arrAnswer0.add(new Answers("G??",false));
        arrAnswer0.add(new Answers("V???t",false));
        arrAnswer0.add(new Answers("Chim",false));

        arrAnswer1.add(new Answers("Xanh",true));
        arrAnswer1.add(new Answers("?????",false));
        arrAnswer1.add(new Answers("T??m",false));
        arrAnswer1.add(new Answers("V??ng",false));

        arrAnswer2.add(new Answers("Long",false));
        arrAnswer2.add(new Answers("R??i",false));
        arrAnswer2.add(new Answers("R???t",false));
        arrAnswer2.add(new Answers("R???ng",true));

        arrQuetion.add(new Quetions(arrAnswer0,"Con g?? c?? 4 ch??n"));
        arrQuetion.add(new Quetions(arrAnswer1, "T??nh ta bi???n b???c ?????ng ... ?"));
        arrQuetion.add(new Quetions(arrAnswer2,"?????u b???c r??ng ... ?"));

        return arrQuetion;
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout,fragment);
        fragmentTransaction.commit();
    }
}