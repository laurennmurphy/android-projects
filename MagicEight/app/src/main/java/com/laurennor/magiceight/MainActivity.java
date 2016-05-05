package com.laurennor.magiceight;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Answers only available inside MainActivity class
    private Answers mAnswers = new Answers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a textview that displays a random answer
        final TextView anAnswer = (TextView) findViewById(R.id.textView2);
        // Create an edittext for a user question
        final EditText aQuestion = (EditText) findViewById(R.id.editText);

        //Create a image that will trigger an answer when clicked
        final ImageView mImageView = (ImageView) findViewById(R.id.imageView);

        // Create an anonymous View.onclicklistener method
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            // This code runs when the listener detects a click on the button
            public void onClick(View view) {
                // Set an error message prompt when a question is not entered
                String errorMsg = aQuestion.getText().toString().trim();
                if(TextUtils.isEmpty(errorMsg)){
                    aQuestion.setError("Please enter a question");
                    return;
                }
                //Display a random answer
                String answer = mAnswers.getAnswer();
                    anAnswer.setText(answer);
            }
        };
        mImageView.setOnClickListener(listener);

    }

}
