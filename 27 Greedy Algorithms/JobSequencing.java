import java.util.*;

public class JobSequencing {
    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        int jobsInfo[][] = {{4,20}, {1,10}, {1,40}, {1,30}};

        ArrayList<Job> jobs = new ArrayList<>();     //An ArrayList of type Job(It is a class)

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));     //Adding data to the array List
        }

        Collections.sort(jobs, (o1, o2) -> o2.profit - o1.profit);     //Comparator to sort on the basis of profit

        ArrayList<Integer> ans = new ArrayList<>();

        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                ans.add(curr.id);
                time++;
            }
        }

        int maxJobs = ans.size();

        System.out.println("Total jobs: " + maxJobs);

        System.out.println(ans);
    }
}
