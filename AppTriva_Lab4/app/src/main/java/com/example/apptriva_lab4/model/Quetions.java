package com.example.apptriva_lab4.model;

import java.util.ArrayList;

public class Quetions {
    private ArrayList<Answers> answer;
    private String question;
    public Quetions(ArrayList<Answers> answer, String question) {
        this.answer = answer;
        this.question = question;
    }
    public ArrayList<Answers> getAnswer() {
        return answer;
    }
    public void setAnswer(ArrayList<Answers> answer) {
        this.answer = answer;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public Quetions() {
    }
}
