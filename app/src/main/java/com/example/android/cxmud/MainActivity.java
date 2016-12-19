package com.example.android.cxmud;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    boolean questionOne, questionTwo, questionThree, questionFour, questionFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view) {

        //question one
        RadioButton radio_questionOne = (RadioButton) findViewById(R.id.radio_vanaert);
        questionOne = radio_questionOne.isChecked();

        //question two
        RadioButton radio_questionTwo = (RadioButton) findViewById(R.id.radio_hyde);
        questionTwo = radio_questionTwo.isChecked();

        //question three
        EditText edit_questionThree = (EditText) findViewById(R.id.edit_questionThree);

        if (edit_questionThree.getText().toString().equals("60") || edit_questionThree.getText().toString().equals("60 minutes") || edit_questionThree.getText().toString().equals("60 min")) {
            questionThree = true;
        } else {
            questionThree = false;
        }

        //question four
        RadioButton radio_questionFour = (RadioButton) findViewById(R.id.radio_no);
        questionFour = radio_questionFour.isChecked();

        //question five
        CheckBox check_essen = (CheckBox) findViewById(R.id.check_essen);
        CheckBox check_koppenberg = (CheckBox) findViewById(R.id.check_koppenberg);
        CheckBox check_namur = (CheckBox) findViewById(R.id.check_namur);
        CheckBox check_vegas = (CheckBox) findViewById(R.id.check_vegas);

        if (check_essen.isChecked() && check_koppenberg.isChecked() && !(check_namur.isChecked()) && !(check_vegas.isChecked())) {
            questionFive = true;
        } else {
            questionFive = false;
        }

        //calculate score
        int result = calculateScore();

        //get name
        String name = getName();

        if (name.equals("")) {
            Toast toast = makeText(this, "Please fill in your name ...", Toast.LENGTH_LONG);
            toast.show();
        } else {
            //display result
            Toast toast = makeText(this, displayScore(name, result), Toast.LENGTH_LONG);
            toast.show();
        }
    }

    //method to calculate score
    public int calculateScore() {
        int score = 0;

        if (questionOne) {
            score += 2;
        }

        if (questionTwo) {
            score += 2;
        }

        if (questionThree) {
            score += 2;
        }

        if (questionFour) {
            score += 2;
        }

        if (questionFive) {
            score += 2;
        }

        return score;
    }

    //method to get users name
    public String getName() {
        EditText edit_name = (EditText) findViewById(R.id.edit_name);
        String name = edit_name.getText().toString();

        return name;
    }

    //method to generate score message
    public String displayScore(String name, int score) {
        String scoreString = "Hello,  " + name + ". ";
        scoreString += "You scored " + score + " out of 10! ";
        scoreString += "Congratulations!";

        return scoreString;
    }
}
