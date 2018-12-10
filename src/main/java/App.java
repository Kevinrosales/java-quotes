import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
public class App {

    public static void main(String[] args) {
        Quote bacon = Quote.RonQuote();
        ArrayList<Quote> quotes = Quote.quoteList();
        if (bacon == null) {
            int random = ThreadLocalRandom.current().nextInt(quotes.size());
            System.out.println(quotes.get(random));
        }else{
            System.out.println(bacon);
        }
    }
}