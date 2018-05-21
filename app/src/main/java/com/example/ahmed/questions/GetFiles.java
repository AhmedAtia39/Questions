package com.example.ahmed.questions;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by AHMED on 20/05/2018.
 */

public class GetFiles {
    Context context;
    ArrayList<String> arr_questions = new ArrayList();
    ArrayList<String> arr_answers = new ArrayList();

    public GetFiles(Context context) {
        this.context = context;
    }

    public ArrayList getQuestions() {
        try {
            InputStream inputStream = context.getAssets().open("questions.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arr_questions.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arr_questions;
    }

    public ArrayList getAnswers() {
        try {
            InputStream inputStream = context.getAssets().open("answers.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                arr_answers.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arr_answers;
    }
}
