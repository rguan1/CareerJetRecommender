import java.util.Set;
import java.util.logging.Level;

/**
 * Created by guanr on 4/27/2018.
 */
public class MainEngine {
    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
        System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        
        APICall singleScrape = new APICall();
        Set<JobPost> setOfJobs = singleScrape.callAPI("computer science intern",
                "San Francisco", "date", "10");
        for (JobPost singlePost : setOfJobs) {
            System.out.println(singlePost.getCompany() + ": " + singlePost.getTitle());
            System.out.println("Job Description: \n" + singlePost.getDescription());
            System.out.println("\n\n");
        }
    }
}
