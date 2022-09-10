/*
 * We have n jobs, where every job is scheduled to be done from startTime[i] to 
 * endTime[i], obtaining a profit of profit[i].
 * 
 * You're given the startTime, endTime and profit arrays, return the maximum profit 
 * you can take such that there are no two jobs in the subset with overlapping time 
 * range.
 * 
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 */

package sdesheet.Day26;

import java.util.*;

public class MaxProfitJobScheduling {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;
        int[][] jobs = new int[len][3];
        
        for (int i = 0; i < len; i++)
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        
        // Sorting jobs based on their end time
        Arrays.sort(jobs, (job1, job2) -> (job1[1] - job2[1]));
        // Map will store the end time and the highest profit 
        // that can be attained upto that time
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 0); // base case
        
        for (int[] job : jobs) {
            // get the immediate lower profit using the current start time
            // and add the profit to that profit
            int curr = job[2] + map.floorEntry(job[0]).getValue();
            // now check i the current profit is greater than last profit added
            if (curr > map.lastEntry().getValue())
                map.put(job[1], curr);
        }
        
        return map.lastEntry().getValue();
    }
}
