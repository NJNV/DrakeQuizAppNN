package org.pattersonclippers.drakequizappnn;

public class Question {

    // instance variables
    private String qText;
    private boolean correctAns;

    public Question(){
        qText = " ";
        correctAns = false;
    }

    // pass-through constructor

    public Question(String newQText, boolean newCorrectAns) {
        qText = newQText;
        correctAns = newCorrectAns;
    }

    // getters
    public String getQText() { return qText;}
    public boolean getCorrectAns(){ return correctAns;}

    // setters
    public void setQText(String newQText) {qText = newQText;}
    public void setCorrectAns(boolean newCorrectAns) {correctAns = newCorrectAns;}

    @Override
    public String toString(){
        return "qText:" + qText + "\n" + "correct answer:" + correctAns;

    }

    




}
