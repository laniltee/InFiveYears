package lk.sliit.ctse.infiveyears.data;

import java.util.ArrayList;
import java.util.List;

public class QuestionData {

    private List<String> questionTitles = new ArrayList();
    private List<String> icons = new ArrayList<>();
    private List<String> colors = new ArrayList<>();
    private int questionIndex;

    public QuestionData() {

        questionTitles.add("Tell us your name.");
        questionTitles.add("In which year you were born?");
        questionTitles.add("Are you in a relationship?");
        questionTitles.add("Are you a optimistic person?");
        questionTitles.add("What do you prefer .. .. Android or iOS?");

        questionIndex = 0;


        colors.add("#E91E63");
        colors.add("#00BCD4");
        colors.add("#9C27B0");
        colors.add("#8BC34A");
        colors.add("#3F51B5");

    }

    public boolean hasNext() {
        return questionIndex < questionTitles.size();
    }

    public Question getNextQuestion() {
        Question question = new Question(
                questionTitles.get(questionIndex),
                "",
                "",
                "boolean",
                colors.get(questionIndex)
        );
        questionIndex++;
        return question;
    }
}
