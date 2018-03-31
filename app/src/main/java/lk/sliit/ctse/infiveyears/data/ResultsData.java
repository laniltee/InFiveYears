package lk.sliit.ctse.infiveyears.data;

import java.util.ArrayList;
import java.util.List;

public class ResultsData {

    private List<String> resultTitles = new ArrayList();
    private List<String> resultSubTitles = new ArrayList<>();
    private List<String> quotes = new ArrayList<>();
    private List<String> colors = new ArrayList<>();
    private List<String> icons = new ArrayList<>();
    private int resultIndex;

    public ResultsData() {
        resultIndex = 0;

        resultTitles.add("Your Marriage !");
        resultTitles.add("Oh ! A Breakdown !");
        resultTitles.add("You are Fined !");
        resultTitles.add("A Sick Pet");

        resultTitles.add("Get Well Soon !");
        resultTitles.add("Taxed !");
        resultTitles.add("Be Careful !");
        resultTitles.add("A Lost Item !");


        resultSubTitles.add("In 5 years, you will be getting married.");
        resultSubTitles.add("You will have to repair your car.");
        resultSubTitles.add("In 5 years you will fined for using your phone while driving");
        resultSubTitles.add("You will have to take your pet to vet doctor !");

        resultSubTitles.add("You will have to stay in a hospital for 1 week !");
        resultSubTitles.add("You will have to pay a big income tax in 5 years because you are earning well !");
        resultSubTitles.add("You are getting injured while you are surfing at beach.");
        resultSubTitles.add("One of the valuable belonging of yourself will be lost while you are on a trip.");

        quotes.add(
                "\"A successful marriage requires falling in love many times, always with the same person\"");
        quotes.add("\"A people without a positive history is like a vehicle without an engine.\"");
        quotes.add("\"As I understand, the role of the federal judiciary, the role of our court system, is to provide justice.\"");
        quotes.add("\"In ancient times cats were worshipped as gods; they have not forgotten this.\"");

        quotes.add("\"Interesting things always come from being really exhausted and really sick\"");
        quotes.add("\"The hardest thing to understand in the world is the income tax.\"");
        quotes.add("\"The more injuries you get, the smarter you get.\"");
        quotes.add("\"Lost time is never found again.\"");

        colors.add("#E91E63");
        colors.add("#00BCD4");
        colors.add("#9C27B0");
        colors.add("#8BC34A");

        colors.add("#3F51B5");
        colors.add("#9C27B0");
        colors.add("#8BC34A");
        colors.add("#E91E63");
        colors.add("#00BCD4");

        icons.add("ic_couple");
        icons.add("ic_garage");
        icons.add("ic_whistle");
        icons.add("ic_cat");

        icons.add("ic_sick");
        icons.add("ic_wallet");
        icons.add("ic_beach");
        icons.add("ic_binoculars");

    }

    public boolean hasNext(){
        return resultIndex < resultTitles.size();
    }

    public Result getNextResult() {
        Result result = new Result(
                resultTitles.get(resultIndex),
                resultSubTitles.get(resultIndex),
                icons.get(resultIndex),
                quotes.get(resultIndex),
                colors.get(resultIndex)
        );
        resultIndex++;
        return result;
    }
}
