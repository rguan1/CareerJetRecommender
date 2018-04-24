import com.careerjet.webservice.api.Client;
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
        System.out.println(output.toString());
    }

}
