import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.BufferedReader;


public class Quote {
    protected String author;
    protected String text;

    public Quote(String author, String text) {
        this.author = author;
        this.text = text;
    }
    //This method gets the Quote from json file and turns it into a quote object
    public static ArrayList<Quote> quoteList() {
        try {
            byte[] text = Files.readAllBytes(Paths.get("assets/recentquotes.json"));
            Gson gson = new Gson();
            ArrayList<Quote> quotes = gson.fromJson(new String(text), new TypeToken<ArrayList<Quote>>(){}.getType());
            return quotes;

        }
        catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }
    //This method gets a Ron Swanson Quote from random.
    public static Quote RonQuote() {
        try {
            URL url = new URL("https://ron-swanson-quotes.herokuapp.com/v2/quotes");
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.setRequestMethod("GET");
            BufferedReader inpu = new BufferedReader(new InputStreamReader(connect.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = inpu.readLine()) != null) {
                content.append(inputLine);
            }
            Quote quote = new Quote("Ron Swanson", content.deleteCharAt(0).deleteCharAt(content.length() -1 ).toString());
            inpu.close();
            return quote;
        }
        catch (IOException e) {
            System.out.println("No internet connection how about a default saved quote instead");
        }
        return null;
    }

    public String toString() {
        return text + " by " + author;
    }
}