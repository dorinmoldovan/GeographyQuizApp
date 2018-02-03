package com.googlescholarship.android.geographyquizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int MAX_SCORE = 4;
    private int finalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method computes the final score of the Geography Quiz App and displays the result in a
     * toast.
     *
     * @param v
     */
    public void computeScore(View v) {
        finalScore = 0;
        computeScoreForTheFirstQuestion();
        computeScoreForTheSecondQuestion();
        computeScoreForTheThirdQuestion();
        computeScoreForTheFourthQuestion();
        Context context = getApplicationContext();
        CharSequence text = getString(R.string.score_message_start) + finalScore
                + getString(R.string.score_message_end) + MAX_SCORE;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * This method computes the score for the first question.
     */
    private void computeScoreForTheFirstQuestion() {
        RadioButton bucharestRadioButton = (RadioButton) findViewById(R.id.bucharest_radio_button);
        if (bucharestRadioButton.isChecked()) {
            finalScore += 1;
        }
    }

    /**
     * This method computes the score for the second question.
     */
    private void computeScoreForTheSecondQuestion() {
        CheckBox franceCheckBox = (CheckBox) findViewById(R.id.france_checkbox);
        CheckBox germanyCheckBox = (CheckBox) findViewById(R.id.germany_checkbox);
        CheckBox russiaCheckBox = (CheckBox) findViewById(R.id.russia_checkbox);
        if (franceCheckBox.isChecked() && germanyCheckBox.isChecked() && !russiaCheckBox.isChecked()) {
            finalScore += 1;
        }
    }

    /**
     * This method computes the score for the third question.
     */
    private void computeScoreForTheThirdQuestion() {
        EditText editText = (EditText) findViewById(R.id.largest_continent);
        if(editText.getText().toString().equals(getString(R.string.asia))) {
            finalScore += 1;
        }
    }

    /**
     * This method computes the score for the fourth question.
     */
    private void computeScoreForTheFourthQuestion() {
        Spinner spinner = (Spinner) findViewById(R.id.continents_spinner);
        if(spinner.getSelectedItem().toString().equals(getString(R.string.australia))) {
            finalScore += 1;
        }
    }

}
