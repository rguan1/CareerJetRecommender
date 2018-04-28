import java.util.Set;

/**
 * Created by guanr on 4/27/2018.
 */
public class MainEngine {
    public static void main(String[] args) {

        APICall singleScrape = new APICall();
        Set<JobPost> setOfJobs = singleScrape.callAPI("computer science intern",
                "new york city", "date", "10");
        for (JobPost singlePost : setOfJobs) {
            System.out.println(singlePost.getCompany() + ": " + singlePost.getTitle());
            System.out.println("Job Description: \n" + singlePost.getDescription());
            System.out.println("\n\n");
        }







    }
}
