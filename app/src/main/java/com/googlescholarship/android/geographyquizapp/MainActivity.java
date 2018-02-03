package com.googlescholarship.android.geographyquizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int finalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void computeScore(View v) {
        finalScore = 0;

        RadioButton bucharestRadioButton = (RadioButton) findViewById(R.id.bucharest_radio_button);
        if(bucharestRadioButton.isChecked()) {
            finalScore++;
        }

        Context context = getApplicationContext();
        CharSequence text = getString(R.string.score_message) + finalScore;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
