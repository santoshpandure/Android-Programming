package com.example.quizapp;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView questionText;
    private RadioGroup optionsGroup;
    private Button nextButton;
    private List<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz); // Set the quiz activity layout

        // Initialize UI components
        questionText = findViewById(R.id.questionText);
        optionsGroup = findViewById(R.id.optionsGroup);
        nextButton = findViewById(R.id.nextButton);

        // Load questions
        loadQuestions();

        // Display the first question
        displayQuestion();

        // Set click listener for the Next button
        nextButton.setOnClickListener(v -> {
            // Check the selected answer
            int selectedOptionId = optionsGroup.getCheckedRadioButtonId();
            if (selectedOptionId != -1) {
                RadioButton selectedOption = findViewById(selectedOptionId);
                String selectedAnswer = selectedOption.getText().toString();

                // Check if the answer is correct
                if (selectedAnswer.equals(questions.get(currentQuestionIndex).getCorrectAnswer())) {
                    score++;
                }

                // Move to the next question or show the result
                currentQuestionIndex++;
                if (currentQuestionIndex < questions.size()) {
                    displayQuestion();
                } else {
                    showResult();
                }
            }
        });
    }

    private void loadQuestions() {
        questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", "Paris", "Berlin", "Madrid", "Rome", "Paris"));
        questions.add(new Question("Which planet is known as the Red Planet?", "Earth", "Mars", "Jupiter", "Venus", "Mars"));
        questions.add(new Question("Who wrote 'Romeo and Juliet'?", "Shakespeare", "Hemingway", "Tolkien", "Austen", "Shakespeare"));
        // Add more questions as needed
    }

    private void displayQuestion() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        questionText.setText(currentQuestion.getQuestion());
        ((RadioButton) optionsGroup.getChildAt(0)).setText(currentQuestion.getOption1());
        ((RadioButton) optionsGroup.getChildAt(1)).setText(currentQuestion.getOption2());
        ((RadioButton) optionsGroup.getChildAt(2)).setText(currentQuestion.getOption3());
        ((RadioButton) optionsGroup.getChildAt(3)).setText(currentQuestion.getOption4());
        optionsGroup.clearCheck(); // Clear previous selection
    }

    private void showResult() {
        // Display the result (you can customize this further)
        setContentView(R.layout.activity_result);
        TextView resultText = findViewById(R.id.resultText);
        resultText.setText("Your score: " + score + "/" + questions.size());
    }

    // Question model class
    static class Question {
        private final String question;
        private final String option1;
        private final String option2;
        private final String option3;
        private final String option4;
        private final String correctAnswer;

        public Question(String question, String option1, String option2, String option3, String option4, String correctAnswer) {
            this.question = question;
            this.option1 = option1;
            this.option2 = option2;
            this.option3 = option3;
            this.option4 = option4;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestion() {
            return question;
        }

        public String getOption1() {
            return option1;
        }

        public String getOption2() {
            return option2;
        }

        public String getOption3() {
            return option3;
        }

        public String getOption4() {
            return option4;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }
    }
}

