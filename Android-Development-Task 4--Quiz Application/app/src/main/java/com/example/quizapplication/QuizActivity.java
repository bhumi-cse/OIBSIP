package com.example.quizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView txtQuestion, txtQuestionTracker;
    private RadioGroup optionsGroup;
    private RadioButton option1, option2, option3, option4;
    private Button btnNext;

    private List<Question> questionList;
    private int currentQuestionIndex = 0;
    private int userScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Bind UI components
        txtQuestion = findViewById(R.id.txtQuestion);
        txtQuestionTracker = findViewById(R.id.txtQuestionTracker);
        optionsGroup = findViewById(R.id.optionsGroup);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);
        btnNext = findViewById(R.id.btnNext);

        loadQuizData();
        displayCurrentQuestion();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = optionsGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    return;
                }

                int selectedOptionIndex = -1;
                if (selectedId == R.id.option1) selectedOptionIndex = 0;
                else if (selectedId == R.id.option2) selectedOptionIndex = 1;
                else if (selectedId == R.id.option3) selectedOptionIndex = 2;
                else if (selectedId == R.id.option4) selectedOptionIndex = 3;

                // Score check
                if (selectedOptionIndex == questionList.get(currentQuestionIndex).getCorrectAnswerIndex()) {
                    userScore++;
                }

                currentQuestionIndex++;

                if (currentQuestionIndex < questionList.size()) {
                    displayCurrentQuestion();
                } else {
                    Intent resultIntent = new Intent(QuizActivity.this, ResultActivity.class);
                    resultIntent.putExtra("SCORE", userScore);
                    resultIntent.putExtra("TOTAL", questionList.size());
                    startActivity(resultIntent);
                    finish();
                }
            }
        });
    }

    private void loadQuizData() {
        questionList = new ArrayList<>();
        questionList.add(new Question("What is the capital of India?", "Mumbai", "New Delhi", "Kolkata", "Chennai", 1));
        questionList.add(new Question("Which programming language is used for native Android development?", "Python", "Swift", "Java", "C#", 2));
        questionList.add(new Question("Which component is used to define layout in Android?", "XML", "JSON", "HTML", "TXT", 0));
    }

    private void displayCurrentQuestion() {
        optionsGroup.clearCheck();

        Question q = questionList.get(currentQuestionIndex);
        txtQuestionTracker.setText("Question " + (currentQuestionIndex + 1) + "/" + questionList.size());
        txtQuestion.setText(q.getQuestionText());

        option1.setText(q.getOptionA());
        option2.setText(q.getOptionB());
        option3.setText(q.getOptionC());
        option4.setText(q.getOptionD());

        if (currentQuestionIndex == questionList.size() - 1) {
            btnNext.setText("Submit");
        }
    }
}