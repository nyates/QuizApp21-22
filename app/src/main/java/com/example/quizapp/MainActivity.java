package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // declare variables
    Button trueBTN;
    Button falseBTN;
    Button nextBTN;
    TextView questionTV;
    int score;
    Question q1;
    Question q2;
    Question q3;
    Question q4;
    Question q5;
    int whichQindex;
    Question[] allQuestions;
    Question currentQ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize our variables & inflate our UI elements
        trueBTN = (Button) findViewById(R.id.trueBTN);
        falseBTN = (Button) findViewById(R.id.falseBTN);
        nextBTN = (Button) findViewById(R.id.nextBTN);
        questionTV = (TextView) findViewById(R.id.questionTV);
        score = 0;
        q1 = new Question("Pi is equal to 3.", false);
        q2 = new Question("Pi is the circumference of a " +
                "circle divided by its diameter.", true);
        q3 = new Question("Pi is irrational", true);
        q4 = new Question("Pi Day is celebrate March 17th.", false);
        q5 = new Question("The area of a circle is equal to pi times the" +
                "radius cubed", false);
        whichQindex = 0;
        allQuestions = new Question[] { q1, q2, q3, q4, q5 };
        currentQ = allQuestions[whichQindex];

        // set true button onClickListener to show a toast incorrect
        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "You got it wrong";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        // set false button onClickListener to show a toast correct
        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "You got it right!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                score = score + 1;
            }
        });

        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (whichQindex >= 4) {
                    Intent myIntent;
                    myIntent = new Intent(MainActivity.this, ScoreActivity.class);
                    myIntent.putExtra("score", score);
                    startActivity(myIntent);
                }
                else
                {
                    // whichQ needs to change to track the current question number
                    whichQindex += 1;
                    // question object needs to change
                    currentQ = allQuestions[whichQindex];
                    // question textview needs to change
                    questionTV.setText(currentQ.getWords());

                }
            }
        });

    }
}