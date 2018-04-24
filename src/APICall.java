import com.careerjet.webservice.api.Client;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by guanr on 4/21/2018.
 */
public class APICall {
    public static void main(String[] args) {
        Map<String, String> arguments = new HashMap<>();
        Client myClient = new Client("en_US");
        arguments.put("keywords", "computer science intern");
        arguments.put("location", "new york city");
        arguments.put("affid", "none");
        arguments.put("user_ip", "");
        arguments.put("user_agent", "client");
        arguments.put("url", "https://www.google.com/");
        JSONObject output = (JSONObject) myClient.search(arguments);

        if (output.get("type").equals("JOBS")) {
            JSONArray jobReturn = (JSONArray) output.get("jobs");
            for (Object obj : jobReturn) {
                JSONObject job = (JSONObject) obj;
                System.out.println("URL         :" + job.get("url"));
                System.out.println("TITLE       :" + job.get("title"));
                System.out.println("COMPANY     :" + job.get("company"));
                System.out.println("SALARY      :" + job.get("salary"));
                System.out.println("DATE        :" + job.get("date"));
                System.out.println("DESCRIPTION :" + job.get("description"));
                System.out.println("SITE        :" + job.get("site"));
                System.out.println("LOCATIONS   :" + job.get("locations"));
                System.out.println("\n");
            }
        }

        //System.out.println(output.toString());
    }

}
