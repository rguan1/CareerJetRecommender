import com.careerjet.webservice.api.Client;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ScriptException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.*;

/**
 * Created by guanr on 4/21/2018.
 */
public class APICall {

    private Client myClient = new Client("en_US");
    private WebClient htmlClient = new WebClient(BrowserVersion.CHROME);
    public APICall() {
    }

    /**
     * method that pulls data from the API. It will add the data to a Set that will be returned
     * @param keyword this is the keyword that will determine search results
     * @param location this is the physical location that will determine where you look for jobs
     * @param sortType three options: relevance, date, salary
     * @param numberResults this is the number of result they want us to return
     * @return Set<JobPost> which will hold all the jobs that are scraped
     */
    public Set<JobPost> callAPI(String keyword, String location, String sortType, String numberResults) {
        Map<String, String> arguments = new HashMap<>();
        Set<JobPost> setOfJobPosts = new HashSet<>();
        arguments.put("keywords", keyword);
        arguments.put("location", location);
        arguments.put("affid", "none");
        arguments.put("user_ip", "");
        arguments.put("user_agent", "client");
        arguments.put("url", "https://www.google.com/");
        arguments.put("sort", sortType);
        arguments.put("pagesize", numberResults);
        JSONObject output = (JSONObject) myClient.search(arguments);

        if (output.get("type").equals("JOBS")) {
            JSONArray jobReturn = (JSONArray) output.get("jobs");
            if (jobReturn != null) {
                for (Object obj : jobReturn) {
                    JSONObject job = (JSONObject) obj;
                    String url = job.get("url").toString();
                    String title = job.get("title").toString();
                    String company = job.get("company").toString();
                    String salary = job.get("salary").toString();
                    String date = job.get("date").toString();
                    String site = job.get("site").toString();
                    String locationOutput = job.get("locations").toString();
                    try {
                        String fullDescription = scrapeDescription(url);
                        JobPost jobPostObj = new JobPost(url, company, date, site,
                                title, salary, fullDescription, locationOutput );
                        setOfJobPosts.add(jobPostObj);
                    } catch (IOException e) {
                        System.out.println (title + " " + company + " url of job could not be scraped");
                    }
                }
            }
        }
        return setOfJobPosts;
    }


    /**
     * method that scrapes directly from the API link. It utilizes both jsoup and
     * htmlUnit (java browser to load dynamic website data).
     * @param url
     * @return String description of the job
     * @throws IOException
     */
    public String scrapeDescription(String url) throws IOException {
            Connection.Response response = Jsoup.connect(url).followRedirects(true).execute();
            String firstURL = response.url().toString();
            System.out.println(firstURL);
        try {
            HtmlPage page = htmlClient.getPage(firstURL);
            Document doc = Jsoup.parse(page.asXml());
            String text = doc.text();
            String noPuncText = text.toLowerCase();
            System.out.println(noPuncText);
            System.out.println("\n\n");
            return noPuncText;
        } catch (ScriptException e) {
            String failString = "no Description available";
            System.out.println(failString);
            return "";
        }
    }



}
