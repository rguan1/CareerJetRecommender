import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Implements the Vector-Space model. 
 * Takes in a job corpus and generates the tf-idf vectors for each job post. 
 * @author dzungnguyen
 */
public class VectorSpaceModel {
    private JobCorpus corpus;
    private Map<JobPost, Map<String, Double>> tfIdfValues;
    
    public VectorSpaceModel(JobCorpus corpus) {
        this.corpus = corpus;
        this.tfIdfValues = new HashMap<>();
        createTfIdfs(); 
    }
    
    /**
     * Creates the tf-idf vectors.
     */
    private void createTfIdfs() {
        Set<String> terms = corpus.getInvertedIndex().keySet();
        for (JobPost job : corpus.getJobs()) {
            Map<String, Double> weights = new HashMap<String, Double>(); 
            for (String term : terms) {
                double tf = job.getFrequency(term);
                double idf = corpus.getIdf(term);
                double tfIdfValue = tf * idf; 
                weights.put(term, tfIdfValue);
            }
            tfIdfValues.put(job, weights); 
        }
    }
    
    /**
     * Calculates the magnitude of the vector representing the input job post.
     * @return 
     */
    private double calculateMagnitude(JobPost job) {
        double mag = 0;
        Map<String, Double> weights = tfIdfValues.get(job);
        for (double weight : weights.values()) {
            mag += weight * weight; 
        }
        
        return Math.sqrt(mag);
    }
    
    /**
     * Take in two jobs and calculate the dot product of their
     * vectors. 
     * @param job1
     * @param job2
     * @return the dot product of the vectors representing the job's 
     * description
     */
    private double calculateDotProduct(JobPost job1, JobPost job2) {
        double product = 0;
        Map<String, Double> weights1 = tfIdfValues.get(job1);
        Map<String, Double> weights2 = tfIdfValues.get(job2); 
        for (String term : weights1.keySet()) {
            product += weights1.get(term) * weights2.get(term);
        }
        return product;
    }
    
    /**
     * Calculates the cosine similarity of two job post objects
     * based on their descriptions.
     * 
     * @param job1
     * @param job2
     * @return the cosine similarity of the two job post objects
     */
    public double cosineSimilarity(JobPost job1, JobPost job2) {
        return calculateDotProduct(job1, job2) / 
                (calculateMagnitude(job1) * calculateMagnitude(job2));
    }
    
           
}
