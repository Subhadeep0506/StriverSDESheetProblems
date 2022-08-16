package com.example.sdesheet.Day08;

import java.util.Arrays;

public class JobSequencing {
    public static void main(String[] args) {
        Job[] arr = new Job[4];
        arr[0] = new Job(1, 4, 20);
        arr[1] = new Job(2, 1, 10);
        arr[2] = new Job(3, 2, 40);
        arr[3] = new Job(4, 2, 30);

        int[] ans = assignJobs(arr, arr.length);

        for (int n: ans) {
            System.out.print(n + " ");
        }
    }

    public static int[] assignJobs(Job[] arr, int n) {
        int[] ans = new int[2];
        // 1st store the max deadline in a variable
        int maxDeadline = 0;
        for(Job job: arr) {
            if (job.deadline > maxDeadline)
                maxDeadline = job.deadline;
        }
        
        // 2nd make an array of that maxProfit size and fill it with -1s.
        int[] res = new int[maxDeadline + 1];
        Arrays.fill(res, -1);
        // 3rd sort the jobs based on profits. Highest profit comes first
        Arrays.sort(arr, (job1, job2) -> (job2.profit - job1.profit));
        
        // 4th loop through array and assign them to the days
        int jobCount = 0, profit = 0;
        for(int i = 0; i < arr.length; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if (res[j] == -1) {
                    res[j] = i;
                    jobCount++;
                    profit += arr[i].profit;
                    break;
                }
            }
        }

        ans[0] = jobCount;
        ans[1] = profit;
        return ans;
    }
}

class Job {
    int id;
    int profit;
    int deadline;

    public Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}