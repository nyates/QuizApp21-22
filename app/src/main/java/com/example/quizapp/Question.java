package com.example.quizapp;

public class Question {

    // instance variables
    private String qWords;
    private boolean correctAnswer;

    //constructor
    public Question(String myWords, boolean myCorrectAnswer)
    {
        qWords = myWords;
        correctAnswer = myCorrectAnswer;
    }

    // methods

    String getWords() { return qWords; }
    void setWords(String newWords) { qWords = newWords; }

    boolean getCorrectAnswer() {return correctAnswer;}
    void setCorrectAnswer(boolean newCorrectAnswer)
    {correctAnswer = newCorrectAnswer;}

}
