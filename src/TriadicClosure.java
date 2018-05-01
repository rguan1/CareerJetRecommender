import java.util.*;

/**
 * Created by guanr on 4/30/2018.
 */
public class TriadicClosure {

    /**
     * static method that computes recommendationList from all the jobs scraped
     * it returns all the jobs ranked in how strong their edge is.
     * @param query
     * @param fullSetOfPossibleJobs
     * @return a list of JobPosts ranked in the strength of their closure to query JobPost
     */
    public static List<JobPost> recommendationList(JobPost query, Set<JobPost> fullSetOfPossibleJobs) {
        Set<String> comparisonWords = new HashSet<>();
        String companyName = query.getCompany().toLowerCase();
        comparisonWords.add(companyName);
        String title = query.getTitle().toLowerCase();

        String[] titleIndividualWords = title.split("\\s+");
        for (String singleWord : titleIndividualWords) {
            comparisonWords.add(singleWord);
        }

        Set<JobPost> modifiedSetThatRemovesQueryJobPost = new HashSet<>();
        modifiedSetThatRemovesQueryJobPost.addAll(fullSetOfPossibleJobs);
        modifiedSetThatRemovesQueryJobPost.remove(query);
        List<JobPost> returnList = compareOtherJobs
                (comparisonWords, modifiedSetThatRemovesQueryJobPost);
        return returnList;
    }

    /**
     * helper method that computes the list of Jobposts to return from the highest strength strong edge
     * to lowest strength strong edge
     * @param comparisonWords
     * @param setOfJobs
     * @return list of JobPosts which have a strong edge with comparisonWords
     */
    private static List<JobPost> compareOtherJobs(Set<String> comparisonWords, Set<JobPost> setOfJobs) {
        PriorityQueue<JobPostRanker> orderedMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (JobPost job : setOfJobs) {
            JobPostRanker addJob = new JobPostRanker(job, comparisonWords);
            orderedMaxHeap.add(addJob);
        }

        List<JobPost> returnList = new ArrayList<>();
        JobPostRanker lastRemovedJobPostRanker = orderedMaxHeap.remove();
        while (lastRemovedJobPostRanker.getMatchValue() > 1 && orderedMaxHeap.size() >= 1) {
            returnList.add(lastRemovedJobPostRanker.getActualJobPost());
            lastRemovedJobPostRanker = orderedMaxHeap.remove();
        }

        return returnList;
    }

}
