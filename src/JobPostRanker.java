import java.util.Set;

/**
 * Created by guanr on 4/30/2018.
 */
public class JobPostRanker implements Comparable<JobPostRanker> {

    private JobPost actualJobPost;
    private Set<String> comparisonWords;
    private int matchValue;

    /**
     * Constructor for JobPostRanker which is just a wrapper class
     * to rank JobPosts by their similarity based on comparisonWords
     * set
     * @param actualJobPost
     * @param comparisonWords
     */
    public JobPostRanker(JobPost actualJobPost, Set<String> comparisonWords) {
        this.actualJobPost = actualJobPost;
        this.comparisonWords = comparisonWords;
        matchValue = computeTriadicSimilarity();
    }

    /**
     * getter function
     * @return actualJobPost field variable
     */
    public JobPost getActualJobPost() {
        return actualJobPost;
    }

    /**
     * getter function
     * @return matchValue field variable
     */
    public int getMatchValue() {
        return matchValue;
    }

    /**
     * helper function to calculate the triadic closure value
     * @return a matchvalue that denotes how close of a match
     * is it to the keywords contained in comparisonWords set
     */
    private int computeTriadicSimilarity() {
        int numberOfMatches = 0;
        String companyName = actualJobPost.getCompany().toLowerCase();
        String title = actualJobPost.getTitle().toLowerCase();
        for (String singleWord : comparisonWords) {
            if (companyName.contains(singleWord)) {
                numberOfMatches = numberOfMatches + 2;
            }

            if (title.contains(singleWord)) {
                numberOfMatches = numberOfMatches + 1;
            }

        }
        return numberOfMatches;
    }

    /**
     * this compareTo function ranks objects bsed on their matchValue
     * larger match values are considered the larger object in this
     * ordering
     * @param o
     * @return int value to denote ordering
     */
    @Override
    public int compareTo(JobPostRanker o) {
        if (this.getMatchValue() < o.getMatchValue()) {
            return -1;
        } else if (this.getMatchValue() == o.getMatchValue()) {
            return 0;
        } else {
            return 1;
        }
    }
}
