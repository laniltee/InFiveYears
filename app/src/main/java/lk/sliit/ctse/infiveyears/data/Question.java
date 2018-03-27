package lk.sliit.ctse.infiveyears.data;

public class Question {

    private String question;

    private String answer;

    private String icon;

    private String answerFormat;

    private String color;

    public Question() {
    }

    public Question(String question, String answer, String icon, String answerFormat, String color) {
        this.question = question;
        this.answer = answer;
        this.icon = icon;
        this.answerFormat = answerFormat;
        this.color = color;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAnswerFormat() {
        return answerFormat;
    }

    public void setAnswerFormat(String answerFormat) {
        this.answerFormat = answerFormat;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
