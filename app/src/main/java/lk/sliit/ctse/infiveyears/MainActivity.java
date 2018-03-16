package lk.sliit.ctse.infiveyears;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
