package org.pattersonclippers.drakequizappnn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ScoreActivity extends AppCompatActivity {

    Button showHSBTN,sendFBBTN;
    EditText nameET;
    Intent incomingIntent;
    TextView scoreTV;
    int score;

    Highscore hs;

    String name;

    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreTV = (TextView) findViewById(R.id.scoreTV);
        incomingIntent = getIntent();
        score = incomingIntent.getIntExtra("score",0);
        scoreTV.setText("" + score);
        showHSBTN = (Button) findViewById(R.id.showHSBTN);
        sendFBBTN = (Button) findViewById(R.id.sendFBBTN);
        nameET = (EditText) findViewById(R.id.nameET);
        name = "";
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Highscore");

        sendFBBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


               name = nameET.getText().toString();
               hs = new Highscore(score,name);
               String key = myRef.push().getKey();
               myRef.child(key).setValue(hs);

            }
        });

        showHSBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ScoreActivity.this,HighScoresActivity.class);
                startActivity(myIntent);
            }
        });








    }



}