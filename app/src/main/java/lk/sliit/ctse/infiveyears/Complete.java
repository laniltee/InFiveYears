package lk.sliit.ctse.infiveyears;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Complete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        getSupportActionBar().hide();
    }

    public void openResultsActivity(View view){
        Intent intent = new Intent(this, ResultsActivity.class);
        startActivity(intent);
    }
}
