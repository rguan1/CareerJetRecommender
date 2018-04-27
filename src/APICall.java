import com.careerjet.webservice.api.Client;
import jdk.nashorn.internal.scripts.JO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

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
        arguments.put("sort", "date");
        arguments.put("pagesize", "50");
        JSONObject output = (JSONObject) myClient.search(arguments);
        Set<JobPost> postingsSet = callAPI("computer science intern",
                "new york city", "date", "50");
        for (JobPost singlePost : postingsSet) {
            System.out.println(singlePost.getCompany() + ": " + singlePost.getTitle());
            System.out.println("Job Description: \n" + singlePost.getDescription());
        }




    }

    public static Set<JobPost> callAPI(String keyword, String location, String sortType, String numberResults) {
        Map<String, String> arguments = new HashMap<>();
        Set<JobPost> setOfJobPosts = new HashSet<>();
        Client myClient = new Client("en_US");
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


        return setOfJobPosts;
    }

    public static String scrapeDescription(String url) throws IOException {
        Document doc = Jsoup.
                connect(url).get();
        Elements ele = doc.select("div.advertise_compact");
        Iterator<Element> iterEle = ele.iterator();
        if (iterEle.hasNext()) {
            Element singleEle = iterEle.next();
            String text = singleEle.text();
            String noPuncText = text.toLowerCase().replaceAll("\\p{Punct}", "");
            return noPuncText;
        } else {
            return url;
        }

    }



}
