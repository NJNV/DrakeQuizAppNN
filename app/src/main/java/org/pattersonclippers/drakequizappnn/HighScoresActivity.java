package org.pattersonclippers.drakequizappnn;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HighScoresActivity extends AppCompatActivity {

    TextView nameTV1,highScoreTV1,nameTV2,highScoreTV2,nameTV3,highScoreTV3;

    FirebaseDatabase database;
    DatabaseReference myRef;

 ArrayList<Highscore> Highscores = new ArrayList<Highscore>();

    public static final String TAG="nnnnn";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_scores);


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Highscore");
        nameTV1 = (TextView) findViewById(R.id.nameTV1);
        highScoreTV1 = (TextView) findViewById(R.id.highScoreTV1);
        nameTV2 = (TextView) findViewById(R.id.nameTV2);
        highScoreTV2 = (TextView) findViewById(R.id.highScoreTV2);
        nameTV3 = (TextView) findViewById(R.id.nameTV3);
        highScoreTV3 = (TextView) findViewById(R.id.highScoreTV3);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

               // Highscore value = snapshot.getValue(Highscore.class);
               // Log.d(TAG, "Value is:" + value);
                for (DataSnapshot HSSnapShot : snapshot.getChildren()) {
                    //From our snapshot, get the value of our key/value pair. This value
                    //contains a customer object
                    Highscore myHS = HSSnapShot.getValue(Highscore.class);

                    Log.d("onDataChange()", "New Highscore: " + myHS.getName());

                    Highscores.add(myHS);
                }

                if (Highscores.size()>0){
                    highScoreTV1.setText(" " + Highscores.get(0).getScore());
                    nameTV1.setText(Highscores.get(0).getName());
                }

                if (Highscores.size()>1){
                    highScoreTV2.setText(" " + Highscores.get(1).getScore());
                    nameTV2.setText(Highscores.get(1).getName());
                }

                if (Highscores.size()>2){
                    highScoreTV3.setText(" " + Highscores.get(2).getScore());
                    nameTV3.setText(Highscores.get(2).getName());
                }



            }

            @Override
            public void onCancelled( DatabaseError error) {
                Log.w(TAG, "Failed to read value.", error.toException());

            }
        });


    }
}