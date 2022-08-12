/*
 * LINK: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * 
 * Solution Explaination:
 * 
 * low = matrix[0][0] = 1, high = matrix[2][2] = 15, mid = 8, count is element number
 * of set {1, 5} = 2, count < k, let low = mid + 1 = 9;
 * 
 * low = 9, high = 15, mid = 12, count is element number of set {1, 5, 9, 10, 11, 12} = 6, count < k, let low = mid + 1 = 13;
 * 
 * low = 13, high = 15, mid = 14, count is element number of set {1, 5, 9, 10, 11, 12, 13, 13} = 8, count = k, but the element we need is 13, not the mid(14), so let high = mid = 14 to narrow the search gap.
 * 
 * low = 13, high = 14, mid = 13, count = 8, count = k, let high = mid = 13,
 * 
 * low = 13, high = 13, low and high are meet, now return low.
 * 
 */

package LeetCode.Aug22;

public class KthSmallestInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];
        int count = 0; // To counts that are less than mid
        
        while (low < high) {
            int tail = n - 1;
            int mid = low + (high - low) / 2;
            count = 0;
            for (int i = 0; i < n; i++) {
                while (tail >= 0 && matrix[i][tail] > mid)
                    tail--;
                count += tail + 1;   
            }
            if (count < k)
                low = mid + 1;
            else 
                high = mid;
        }
        
        return low;
    }
}
