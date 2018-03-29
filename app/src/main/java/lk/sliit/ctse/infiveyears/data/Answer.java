package lk.sliit.ctse.infiveyears.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Answer extends RealmObject{

    @PrimaryKey
    private String index;
    private String question;
    private String answer;

    public Answer() {
    }

    public Answer(String index, String question, String answer) {
        this.index = index;
        this.question = question;
        this.answer = answer;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "index='" + index + '\'' +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
