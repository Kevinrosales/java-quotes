import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class App {

    public static void main(String[] args) {
        System.out.println(randomGenerator());
    }

    public static String randomGenerator(){
        try{
            //declaring a new Gson
            Gson gson = new Gson();

            //here we use the BufferedReader to read the recentquotes.json file
            BufferedReader reader = new BufferedReader(new FileReader("assets/recentquotes.json"));

            //convert the json Array to Java object that will be used as a quote
            Quote[] quotes = gson.fromJson(reader, Quote[].class);

            //this method will give us the random number that will be used to pick a random title from the book list
            int rand = (int)(Math.random()*(quotes.length));
            return quotes[rand].toString();
            } catch (IOException e){
                e.printStackTrace();
                return null;
        }
    }
}