package com.laurennor.magiceight;

import java.util.Random;

/**
 * Created by laurennor on 2/11/16.
 */
public class Answers {

    // Create an response array
    String[] allResponses = {"Yes", "No", "Outlook not so good", "Absolutely", "Ask again later", "Never", "Maybe",
            "Better luck next time", "No Way!", "It is certain","Signs point to yes", "Don't count on it",
            "As I see it, yes", "Very doubtful", "Most likely" , "Without a doubt", "My reply is no",
            "Better luck next time", "My sources say no", "You may rely on it"
    };



    public String getAnswer(){

        // Create a string for all the responses
        String answer = "";


        // Randomly select an answer
        Random randomGenerator = new Random(); // Construct new Random number generator
        int randomNumber = randomGenerator.nextInt(allResponses.length);

        answer = allResponses[randomNumber];


        return answer;

    }
}
