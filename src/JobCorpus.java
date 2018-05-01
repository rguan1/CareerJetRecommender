import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Represents a collection of job post objects.
 * Creates an inverted index of unique terms in the collection. 
 * @author dzungnguyen
 */
public class JobCorpus {
    private List<JobPost> jobs;
    private Map<String, Set<JobPost>> invertedIndex; 
    private double corpusSize; 
    
    public JobCorpus(List<JobPost> jobs) { 
        this.jobs = jobs;
         this.corpusSize = jobs.size(); 
        this.invertedIndex = new HashMap<>();
        makeInvertedIndex(); 
    }
    
    /**
     * Creates a mapping of unique terms to the job posts
     * that they appear in. 
     */
    private void makeInvertedIndex() {
        
        for (JobPost job : jobs) {
            Set<String> terms = job.getTerms();
            for (String term : terms) {
                if (invertedIndex.containsKey(term)) {
                    invertedIndex.get(term).add(job); 
                } else {
                    Set<JobPost> jobSet = new HashSet<>();
                    jobSet.add(job);
                    invertedIndex.put(term, jobSet);
                }
            }
        }
    }
    
    /**
     * Retrieves the idf value for the given term. 
     * 
     * @param term the term in the job collection
     * @return the idf for the term if it exists in the corpus, 0 otherwise
     */
    public double getIdf(String term) {
        if (invertedIndex.containsKey(term)) {
            Set<JobPost> list = invertedIndex.get(term);
            double jobsContainingTerm = list.size();
            return Math.log(corpusSize/jobsContainingTerm);
        } else {
            return 0; 
        }
    }
    
    /**
     * Returns the list of jobs in the corpus.
     * 
     * @return the list of jobs in the corpus
     */
    public List<JobPost> getJobs() {
        return jobs; 
    }
    
    /**
     * Returns the invertedIndex represented by this instance of JobCorpus.
     * 
     * @return the invertedIndex
     */
    public Map<String, Set<JobPost>> getInvertedIndex() {
        return invertedIndex; 
    }
    
    
}
