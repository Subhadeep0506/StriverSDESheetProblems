/*  
* Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, 
* and return an array of the non-overlapping intervals that cover all the intervals in the input.
*
* Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
* Output: [[1,6],[8,10],[15,18]]
* Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
*/

package sdesheet.Day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals == null) 
            return intervals;
        
        Arrays.sort(intervals, 
                    (interval1, interval2) -> Integer.compare(interval1[0], interval2[0]));
        
        List<int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for (int[] interval: intervals) {
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            }
            else {
                result.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][]);
    }
}
