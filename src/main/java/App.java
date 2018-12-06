import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import com.google.gson.JsonSyntaxException;

public class App {

    public static void main(String[] args) {

        Gson gson = new Gson();
        BufferedReader br = null;
        Quote quote = new Quote();
        try {
            br = new BufferedReader(new FileReader("recentquotes.JSON"));
            Quote String [] ; gson.fromJson(br, Quote[].class);
//
            if (quote != null) {
                System.out.println(quote.getAuthors() + " " + quote.getText() + " " + quote.getLikes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if(br != null){
                try{
                    br.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}