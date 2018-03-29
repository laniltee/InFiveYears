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

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import lk.sliit.ctse.infiveyears.data.Answer;
import lk.sliit.ctse.infiveyears.data.Question;
import lk.sliit.ctse.infiveyears.data.QuestionData;

/**
 * @author Lanil Marasinghe
 */
public class MainActivity extends AppCompatActivity {

    // Question library
    QuestionData questionData;

    // UI Elements
    TextView tv_questionText;
    TextView tv_qIndex;
    EditText et_answer;

    // Realm DB
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing question data;
        questionData = new QuestionData();

        // Hiding the app bar
        getSupportActionBar().hide();

        // Initializing DB connection
        // Initializing Realm Database
        Realm.init(this);
        try {
            realm = Realm.getDefaultInstance();

        } catch (Exception e) {
            // Get a Realm instance for this thread
            RealmConfiguration config = new RealmConfiguration.Builder()
                    .deleteRealmIfMigrationNeeded()
                    .build();
            realm = Realm.getInstance(config);
        }


        // Initializing UI elements
        tv_questionText = findViewById(R.id.tv_questionText);
        tv_qIndex = findViewById(R.id.tv_qIndex);
        et_answer = findViewById(R.id.et_answer);

        this.getNextQuestion(null);

    }

    public void getNextQuestion(View view) {
        String answer = et_answer.getText().toString();
        if (questionData.getQuestionIndex() > 0 && answer.matches("")) {
            Toast.makeText(MainActivity.this, "We need the answer !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (questionData.hasNext()) {

            et_answer.setText("");
            Question question = questionData.getNextQuestion();
            tv_questionText.setText(question.getQuestion());
            String qIndex = questionData.getQuestionIndex() + " / 10";
            tv_qIndex.setText(qIndex);

            // Saving user's answer to DB
            if (questionData.getQuestionIndex() > 0) {
                realm.beginTransaction();

                Answer savingAnswer = new Answer();
                savingAnswer.setQuestion(question.getQuestion());
                savingAnswer.setIndex(String.valueOf(questionData.getQuestionIndex()));
                savingAnswer.setAnswer(answer);

                realm.copyToRealmOrUpdate(savingAnswer);
                realm.commitTransaction();
            }


            View currentView = findViewById(R.id.activity_main);
            currentView.setBackgroundColor(Color.parseColor(question.getColor()));
        } else {
            this.openCompleteActivity(view);
        }
    }

    public void openResultsActivity(View view) {
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }

    public void openWelcomeActivity(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

    public void openCompleteActivity(View view) {
        Intent intent = new Intent(this, Complete.class);
        startActivity(intent);
    }
}
