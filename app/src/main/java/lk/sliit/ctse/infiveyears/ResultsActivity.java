package lk.sliit.ctse.infiveyears;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

import lk.sliit.ctse.infiveyears.data.Result;
import lk.sliit.ctse.infiveyears.data.ResultsData;

public class ResultsActivity extends AppCompatActivity {

    ResultsData resultsData;

    // UI elements
    TextView tvResultTitle;
    TextView tvResultSubTitle;
    TextView tvResultQuote;
    Button btnShowNextResult;
    ImageView ivIcon;

    // Icon set
    HashMap<String, Integer> hashMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //Hiding the app bar
        getSupportActionBar().hide();

        // Initializing data fetch helper
        resultsData = new ResultsData();

        // Initalizing UI elements
        tvResultQuote = findViewById(R.id.tv_resultQuote);
        tvResultSubTitle = findViewById(R.id.tv_resultSubTitle);
        tvResultTitle = findViewById(R.id.tv_resultTitle);
        btnShowNextResult = findViewById(R.id.btn_showNextResult);
        ivIcon = findViewById(R.id.ivIcon);

    }

    public void getNextResult(View view) {
        if (btnShowNextResult.getText().toString().equals("Take me back")) {
            this.openHomeActivity(view);
            return;
        }
        View currentView = findViewById(R.id.activity_result);
        Result result;
        if (resultsData.hasNext()) {
            result = resultsData.getNextResult();
            tvResultTitle.setText(result.getTitle());
            tvResultSubTitle.setText(result.getSubTitle());
            tvResultQuote.setText(result.getQuote());

            // Setting icon in image view
            String imageUri = "@drawable/" + result.getIcon();
            int imageResource = getResources().getIdentifier(imageUri, null, getPackageName());
            Drawable drawable = getResources().getDrawable(imageResource);
            ivIcon.setImageDrawable(drawable);

            currentView.setBackgroundColor(Color.parseColor(result.getColor()));
            btnShowNextResult.setTextColor(Color.parseColor(result.getColor()));
        } else {
            tvResultTitle.setText(R.string.thank1);
            tvResultSubTitle.setText(R.string.thank2);
            tvResultQuote.setText(R.string.thank3);
            btnShowNextResult.setText(R.string.thank4);
            //this.openQuestionActivity(view);
        }
    }


    public void openQuestionActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openHomeActivity(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }
}
