/*
 * https://leetcode.com/problems/minimum-number-of-refueling-stops/
 * 
 * The intution here is that we only chode to stop at those stations where we can
 * get maximum fuel in out journey.
 * 
 * Discussion: https://leetcode.com/problems/minimum-number-of-refueling-stops/discuss/294025/Java-Simple-Code-Greedy
 */

package sdesheet.LeetCode.Aug22;

import java.util.*;

public class MinimumNumberOfRefuellingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        // If starting fuel is enough to reach destination, we need not stop at any stations.
        // So we return 0
        if (startFuel >= target)
            return 0;
        
        // We make a priority Queue to store the fuels in descending order
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b -  a));
        
        int i = 0;
        int n = stations.length;
        int maxDistance = startFuel;
        int stops = 0;
        
        // We take a while loop and iterate until we reach target
        while (maxDistance < target) {
            // from i, we check all the stations upto our maximum reachable destination 
            // and add the amount of fuel, that can be taken from the station, to the 
            // queue
            while (i < n && stations[i][0] <= maxDistance) {
                queue.offer(stations[i++][1]);
            }
            
            // If we were not able to reach any station, we return -1
            if (queue.isEmpty())
                return -1;
            
            // If we were able to reach the maximum destination, we increase our maximum 
            // reachable destination with the maximum fuel that we can take from among the 
            // stations
            maxDistance += queue.poll();
            // We indrease our stop count
            stops++;
        }
        
        return stops;
    }
}
