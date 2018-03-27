package lk.sliit.ctse.infiveyears;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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

    }

    public void getNextQuestion(View view){
        if(questionData.hasNext()){
            Question question = questionData.getNextQuestion();
            tv_questionText.setText(question.getQuestion());
            String qIndex = questionData.getQuestionIndex() + " / 10";
            tv_qIndex.setText(qIndex);
        }else{
            this.openResultsActivity(view);
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
}
