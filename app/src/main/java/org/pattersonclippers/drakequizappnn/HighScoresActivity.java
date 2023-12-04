package org.pattersonclippers.drakequizappnn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HighScoresActivity extends AppCompatActivity {

    TextView NameTV,HighScoreTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);

        NameTV = (TextView) findViewById(R.id.NameTV);
        HighScoreTV = (TextView) findViewById(R.id.HighScoreTV);

    }
}