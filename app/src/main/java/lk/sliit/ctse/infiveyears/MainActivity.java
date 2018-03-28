package lk.sliit.ctse.infiveyears;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import lk.sliit.ctse.infiveyears.data.Question;
import lk.sliit.ctse.infiveyears.data.QuestionData;

/**
 *
 * @author Lanil Marasinghe
 *
 */
public class MainActivity extends AppCompatActivity {

    // Question library
    QuestionData questionData;

    // UI Elements
    TextView tv_questionText;
    TextView tv_qIndex;
    EditText et_answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing question data;
        questionData = new QuestionData();

        // Hiding the app bar
        getSupportActionBar().hide();


        // Initializing UI elements
        tv_questionText = findViewById(R.id.tv_questionText);
        tv_qIndex = findViewById(R.id.tv_qIndex);
        et_answer = findViewById(R.id.et_answer);

        this.getNextQuestion(null);

    }

    public void getNextQuestion(View view){
        String answer = et_answer.getText().toString();
        if(questionData.getQuestionIndex() > 0 && answer.matches("")){
            Toast.makeText(MainActivity.this, "We need the answer !", Toast.LENGTH_SHORT).show();
            return;
        }
        if(questionData.hasNext()){
            et_answer.setText("");
            Question question = questionData.getNextQuestion();
            tv_questionText.setText(question.getQuestion());
            String qIndex = questionData.getQuestionIndex() + " / 10";
            tv_qIndex.setText(qIndex);

            View currentView = findViewById(R.id.activity_main);
            currentView.setBackgroundColor(Color.parseColor(question.getColor()));
        }else{
            this.openCompleteActivity(view);
        }
    }

    public void openResultsActivity(View view){
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }

    public void openWelcomeActivity(View view){
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

    public void openCompleteActivity(View view){
        Intent intent = new Intent(this, Complete.class);
        startActivity(intent);
    }
}
