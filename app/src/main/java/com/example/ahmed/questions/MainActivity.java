package com.example.ahmed.questions;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arr_questions;
    ArrayList<String> arr_answers;
    GetFiles getFiles;

    int num = 0;
    String x[];

    TextView txt_Ans1, txt_Ans2, txt_Ans3, txt_Ques;
    ArrayList arr_store_ques;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_Ques = (TextView) findViewById(R.id.textQues);
        txt_Ans1 = (TextView) findViewById(R.id.textAns1);
        txt_Ans2 = (TextView) findViewById(R.id.textAns2);
        txt_Ans3 = (TextView) findViewById(R.id.textAns3);

        getFiles = new GetFiles(this);

        arr_questions = getFiles.getQuestions();
        arr_answers = getFiles.getAnswers();
        arr_store_ques = new ArrayList();

        getOneQuestion();
    }

    public void getOneQuestion() {
        if (arr_store_ques.size() < arr_questions.size()) {
            Random r = new Random();
            num = r.nextInt(arr_questions.size());

            String question = arr_questions.get(num);
            boolean check = true;
            for (int i = 0; i < arr_store_ques.size(); i++) {

                if (question.equals(arr_store_ques.get(i))) {
                    check = false;
                    getOneQuestion();
                }
            }
            if (check) {
                txt_Ques.setText(arr_questions.get(num));
                arr_store_ques.add(arr_questions.get(num));

                x = arr_answers.get(num).split(",");

                txt_Ans1.setText(x[0]);
                txt_Ans2.setText(x[1]);
                txt_Ans3.setText(x[2]);
            }

        } else {
            txt_Ques.setText("");
            txt_Ans1.setText("");
            txt_Ans2.setText("");
            txt_Ans3.setText("");

            txt_Ans1.setEnabled(false);
            txt_Ans2.setEnabled(false);
            txt_Ans3.setEnabled(false);

            txt_Ans2.setText("انتهت الاسئله");
            txt_Ans2.setTextColor(Color.RED);
        }

    }

    public void ans1(View view) {
        // i use textview to can convert from string to int
        TextView t = new TextView(this);
        t.setText(x[3]);

        int x2 = Integer.parseInt(t.getText().toString().trim());

        if (x2 == 0) {
            Toast.makeText(this, "الاجابه صحيحه", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "الاجابه خاطئه", Toast.LENGTH_SHORT).show();
        }

        getOneQuestion();

    }

    public void ans2(View view) {
        TextView t = new TextView(this);
        t.setText(x[3]);

        int x2 = Integer.parseInt(t.getText().toString().trim());

        if (x2 == 1) {
            Toast.makeText(this, "الاجابه صحيحه", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "الاجابه خاطئه", Toast.LENGTH_SHORT).show();
        }

        getOneQuestion();

    }

    public void ans3(View view) {
        TextView t = new TextView(this);
        t.setText(x[3]);

        int x2 = Integer.parseInt(t.getText().toString().trim());

        if (x2 == 2) {
            Toast.makeText(this, "الاجابه صحيحه", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "الاجابه خاطئه", Toast.LENGTH_SHORT).show();
        }

        getOneQuestion();
    }
}
