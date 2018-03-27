package lk.sliit.ctse.infiveyears;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import lk.sliit.ctse.infiveyears.data.QuestionData;

/**
 *
 * @author Lanil Marasinghe
 *
 */
public class MainActivity extends AppCompatActivity {

    // Question library
    QuestionData questionData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing question data;
        questionData = new QuestionData();

        // Hiding the app bar
        getSupportActionBar().hide();



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
