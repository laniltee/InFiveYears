package lk.sliit.ctse.infiveyears;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import lk.sliit.ctse.infiveyears.data.Result;
import lk.sliit.ctse.infiveyears.data.ResultsData;

public class ResultsActivity extends AppCompatActivity {

    ResultsData resultsData;

    // UI elements
    TextView tvResultTitle;
    TextView tvResultSubTitle;
    TextView tvResultQuote;
    Button btnShowNextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Initializing data fetch helper
        resultsData = new ResultsData();

        // Initalizing UI elements
        tvResultQuote = findViewById(R.id.tv_resultQuote);
        tvResultSubTitle = findViewById(R.id.tv_resultSubTitle);
        tvResultTitle = findViewById(R.id.tv_resultTitle);
        btnShowNextResult = findViewById(R.id.btn_showNextResult);

    }

    public void getNextResult(View view){
        View currentView = findViewById(R.id.activity_result);
        Result result;
        if(resultsData.hasNext()){
            result = resultsData.getNextResult();
            tvResultTitle.setText(result.getTitle());
            tvResultSubTitle.setText(result.getSubTitle());
            tvResultQuote.setText(result.getQuote());
            currentView.setBackgroundColor(Color.parseColor(result.getColor()));
            btnShowNextResult.setTextColor(Color.parseColor(result.getColor()));
        }else{
            this.openQuestionActivity(view);
        }
    }


    public void openQuestionActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
