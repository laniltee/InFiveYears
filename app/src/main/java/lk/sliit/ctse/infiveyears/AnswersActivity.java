package lk.sliit.ctse.infiveyears;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import lk.sliit.ctse.infiveyears.data.Answer;

public class AnswersActivity extends AppCompatActivity {

    ListView lv_answers;

    // Realm DB
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        getSupportActionBar().hide();

        lv_answers = findViewById(R.id.lv_answers);

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

        loadPreviousAnswers();
    }

    // Loads answered questions from DB
    public void loadPreviousAnswers(){
        RealmResults<Answer> results = realm.where(Answer.class).findAllAsync();
        results.load();


        int index = 0;
        String[] listItems;

        if(results.size() == 0){
            listItems = new String[1];
            listItems[0] = "YOU HAVEN'T ANSWERED ANY OF THE QUESTIONS";
        }else{
            listItems = new String[results.size()];
            for(Answer answer:results){

                String question = answer.getQuestion();
                String answered = answer.getAnswer();

                if(answered.matches("")){
                    listItems[index] = question + ": " + "NOT_ANSWERED";
                }else{
                    listItems[index] = question + ": " + answered;
                }
                index++;
                System.out.println(answer.toString());
            }

        }


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
        lv_answers.setAdapter(arrayAdapter);
    }
}
