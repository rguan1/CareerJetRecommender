/**
 * Created by guanr on 4/27/2018.
 */
public class JobPost {
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
}
