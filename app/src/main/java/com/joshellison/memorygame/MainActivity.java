package com.joshellison.memorygame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener{

    //for high score
    SharedPreferences prefs;
    String dataName = "MyData";
    String intName = "MyInt";
    int defaultInt = 0;
    int highScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for high score
        //initialize two SharedPreferences objects
        prefs = getSharedPreferences(dataName,MODE_PRIVATE);

        //Either load High score or
        //if not available our default of 0
        highScore = prefs.getInt(intName, defaultInt);

        //Make a reference to the Highscore textview in layout
        TextView textHighScore =(TextView) findViewById(R.id.textHighScore);
        //Display the hi score
        textHighScore.setText("High: "+ highScore);

        //Make a button from the button in layout
        Button button =(Button) findViewById(R.id.button);

        //Make each listen for clicks
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        Intent i;
        i = new Intent(this, GameActivity.class);
        startActivity(i);

    }
}
