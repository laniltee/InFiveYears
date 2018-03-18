package lk.sliit.ctse.infiveyears.data;

public class Result {

    private String title;

    private String subTitle;

    private String icon;

    private String quote;

    private String color;

    public Result() {
    }

    public Result(String title, String subTitle, String icon, String quote, String color) {
        this.title = title;
        this.subTitle = subTitle;
        this.icon = icon;
        this.quote = quote;
        this.color = color;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
