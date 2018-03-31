package lk.sliit.ctse.infiveyears.data;

import java.util.ArrayList;
import java.util.List;

public class QuestionData {

    private List<String> questionTitles = new ArrayList();
    private List<String> icons = new ArrayList<>();
    private List<String> colors = new ArrayList<>();
    private int questionIndex;

    public QuestionData() {

        questionTitles.add("Before we start, We need to know your name.");
        questionTitles.add("In which year you were born?");
        questionTitles.add("Are you in a relationship?");
        questionTitles.add("Are you a optimistic person?");
        questionTitles.add("How many people depend upon you ?");
        questionTitles.add("Do you have a permanent job ?");
        questionTitles.add("Who do you prefer, cats or dogs ?");
        questionTitles.add("Do you have a emergency fund");
        questionTitles.add("Do you have a life insurance ?");
        questionTitles.add("What is the last time you went to a hospital ?");

        questionIndex = 0;


        colors.add("#E91E63");
        colors.add("#7E57C2");
        colors.add("#3F51B5");
        colors.add("#0097A7");
        colors.add("#4CAF50");
        colors.add("#FFF176");
        colors.add("#9E9D24");
        colors.add("#795548");
        colors.add("#2E7D32");
        colors.add("#01579B");

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

    public Question getQuestionById(int index) {
        Question question = new Question(
                questionTitles.get(index),
                "",
                "",
                "boolean",
                colors.get(index)
        );
        return question;
    }

    public int getQuestionIndex() {
        return questionIndex;
    }
}
