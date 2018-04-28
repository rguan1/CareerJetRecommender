
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by guanr on 4/27/2018.
 */
public class JobPost implements Comparable<JobPost>{
    /**
     * Constructor for JobPost obj
     * holds relevant fields
     */

    private String jobLink;
    private String company;
    private String date;
    private String site;
    private String title;
    private String salary;
    private String description;
    private String locations;  
    private double cosineSimValue; 
    private Map<String, Integer> termFrequency; 

    /**
     *
     * @param jobLink
     * @param company
     * @param date
     * @param site
     * @param title
     * @param salary
     * @param description
     * @param locations
     * Constructor for an object that holds a single job posting.
     */
    public JobPost(String jobLink, String company, String date, String site, String title,
                   String salary, String description, String locations) {
        this.jobLink = jobLink;
        this.company = company;
        this.date = date;
        this.site = site;
        this.title = title;
        this.salary = salary;
        this.description = description;
        this.locations = locations;
        this.termFrequency = new HashMap<String, Integer>();
        this.cosineSimValue = 0; 
        processDescription();
    }
    
    /**
     * Constructor for the query input by the user.
     * 
     * @param description
     * @param locations 
     */
    public JobPost(String description, String locations, String title) {
        this(null, null, null, null, title, null, description, locations);
        processDescription(); 
    }

    public String getJobLink() {
        return jobLink;
    }

    public void setJobLink(String jobLink) {
        this.jobLink = jobLink;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }
    
    public void setCosineSimilarity(double cosineValue) {
        this.cosineSimValue = cosineValue; 
    }
    /**
     * Goes through the description of the job, pre-process it (turn terms
     * into lower case, replace all non-alphabetic characters)
     */
    private void processDescription() {
        Scanner sc = new Scanner(this.description); 
        while (sc.hasNext()) {
            String nextTerm = sc.next().replaceAll("[^A-Za-z0-9]", "").trim();
            if (!(nextTerm.equals(""))) {
                if (termFrequency.containsKey(nextTerm)) {
                    int prevFrequency = termFrequency.get(nextTerm); 
                    termFrequency.put(nextTerm, ++prevFrequency);
                } else {
                    termFrequency.put(nextTerm, 1); 
                }
            }
        }
        sc.close();
    }
    
    /**
     * Retrieves the frequency corresponding to the input term. 
     * 
     * @param term the term corresponding to the output frequency
     * @return the frequency corresponding to the input term
     */
    public int getFrequency(String term) {
        if (termFrequency.keySet().contains(term)) {
            return termFrequency.get(term);
        } else {
            return 0;
        }
    }
    
    /**
     * Retrieves the set of unique terms in the document. 
     * 
     * @return the set of terms in the document. 
     */
    public Set<String> getTerms() {
        return termFrequency.keySet(); 
    }
    
    public double getCosineSimValue() {
        return this.cosineSimValue; 
    }
    
    @Override
    public int compareTo(JobPost other) {
        if (this.cosineSimValue > other.cosineSimValue) {
            return -1;
        } else if (this.cosineSimValue < other.cosineSimValue) {
            return 1; 
        } else {
            return 0; 
        }
    }
    
    @Override
    public String toString() {
        return title + ": " + locations; 
    }
    
}
