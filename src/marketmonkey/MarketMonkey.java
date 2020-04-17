package marketmonkey;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import org.json.*;

/**
 *
 * @author Alexander
 */
public class MarketMonkey {

    public static int stockPicks=10;
    public static ArrayList<String> stocks = new ArrayList<>();
    
    public static void main(String[] args) {
        
        String jsonData = readFile("Supported Stocks.json");
        
        JSONObject stockList = new JSONObject(jsonData);

        //System.out.println(stockList.getJSONArray("stocks"));
        
        JSONArray stockArray=stockList.getJSONArray("stocks");
        
        for(int i=0; i<stockArray.length(); i++) {
            stocks.add(stockArray.getJSONObject(i).get("description") + " (" + stockArray.getJSONObject(i).get("symbol")+")" );
        }
        
        Collections.shuffle(stocks);
        
        for(int i=0; i<stockPicks; i++) {
            System.out.println(stocks.get(i));
        }
        
    }
    
    public static String readFile(String filename) {
    String result = "";
    try {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            line = br.readLine();
        }
        result = sb.toString();
    } catch(Exception e) {
        e.printStackTrace();
    }
    return result;
}
    
}
