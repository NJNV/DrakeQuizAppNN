package org.pattersonclippers.drakequizappnn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    Button emailBTN;

    Intent incomingIntent;
    TextView scoreTV;
    int score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        scoreTV = (TextView) findViewById(R.id.scoreTV);
        incomingIntent = getIntent();
        score = incomingIntent.getIntExtra("score",0);
        scoreTV.setText("" + score);
        emailBTN = (Button) findViewById(R.id.emailBTN);





    }

   // emailBTN.setOnClickListener(new View.OnClickListener() {
     //   @Override
       // public void onClick(View view) {
         //   Intent intent = new Intent(Intent.ACTION_SENDTO);
           // intent.setData(Uri.parse("mailto:")); // Only email apps handle this.
            //intent.putExtra(Intent.EXTRA_SUBJECT, "this is the score");
            //intent.putExtra(Intent.EXTRA_TEXT, "Body");
            //if (intent.resolveActivity(getPackageManager()) != null) {
            //    startActivity(intent);
            //}
       // }
    //});


}