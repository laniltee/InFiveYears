package lk.sliit.ctse.infiveyears;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import lk.sliit.ctse.infiveyears.data.Answer;

public class QuestionActivity extends AppCompatActivity {

    // Realm DB
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

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
    }

    public void openQuestionActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void loadPreviousAnswers(View view){
        System.out.println();
        RealmResults<Answer> results = realm.where(Answer.class).findAllAsync();
        results.load();
        for(Answer answer:results){
            System.out.println(answer.toString());
        }
    }
}
