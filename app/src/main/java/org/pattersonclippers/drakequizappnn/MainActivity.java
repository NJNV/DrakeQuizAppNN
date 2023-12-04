package org.pattersonclippers.drakequizappnn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView questionTV;
    Button trueBTN, falseBTN, scoreBTN, nextBTN;
    String showAnswer;
    int score, currentIndex;
    Question q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, currentQ;
    Question[] questions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        questionTV = (TextView) findViewById(R.id.questionTV);
        trueBTN = (Button) findViewById(R.id.trueBTN);
        falseBTN = (Button) findViewById(R.id.falseBTN);
        showAnswer = "";
        score = 0;
        scoreBTN = (Button) findViewById(R.id.scoreBTN);
        nextBTN = (Button) findViewById(R.id.nextBTN);
        q1 = new Question(getString(R.string.q1text), false);
        q2 = new Question(getString(R.string.q2text),true);
        q3 = new Question(getString(R.string.q3text),false);
        q4 = new Question(getString(R.string.q4text), false);
        q5 = new Question(getString(R.string.q5text), true);
        q6 = new Question(getString(R.string.q6text), true);
        q7 = new Question(getString(R.string.q7text), true);
        q8 = new Question(getString(R.string.q8text), false);
        q9 = new Question(getString(R.string.q9text), true);
        q10 = new Question(getString(R.string.q10text), true);
        questions = new Question[]{q1, q2, q3, q4, q5, q6, q7, q8, q9, q10,};
        currentIndex = 0;
        currentQ = questions[currentIndex];

        trueBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQ.getCorrectAns() == true) {
                    showAnswer = getString(R.string.correctMSG);
                    score = score + 1;
                } else {
                    showAnswer = getString(R.string.wrongMSG);
                }


                int duration = Toast.LENGTH_SHORT;
                Toast t = Toast.makeText(getApplicationContext(), showAnswer, duration);
                t.show();

            }
        });

        falseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentQ.getCorrectAns() == false) {
                    showAnswer =  getString(R.string.correctMSG);
                    score = score + 1;
                } else {
                    showAnswer =  getString(R.string.wrongMSG) ;
                }

                int duration = Toast.LENGTH_SHORT;
                Toast t = Toast.makeText(getApplicationContext(), showAnswer, duration);
                t.show();

            }
        });


        scoreBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, ScoreActivity.class);
                myIntent.putExtra("score", score);
                startActivity(myIntent);
            }


        });

        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex++;
                if(currentIndex<10) {
                    currentQ = questions[currentIndex];
                    questionTV.setText(currentQ.getQText());
                }

                else {

                    Intent myIntent = new Intent(MainActivity.this, ScoreActivity.class);
                    myIntent.putExtra("score", score);
                    startActivity(myIntent);

                }

            }

        });



    }
}
