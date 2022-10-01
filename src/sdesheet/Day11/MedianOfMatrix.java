/*
 * Given a row-wise sorted matrix of size r*c, where r is no. of rows and c is no. of columns, 
 * find the median in the given matrix.
 * 
 * explaination link:- https://takeuforward.org/data-structure/median-of-row-wise-sorted-matrix/
 * 
 *  
 */

package sdesheet.Day11;

import java.util.ArrayList;

public class MedianOfMatrix {
    public static int findMedian(ArrayList<ArrayList<Integer>> matrix) {
        int low = 1, high = (int)1e9;
        int n = matrix.size();
        int m = matrix.get(0).size();
        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += countSmallerThanMid(matrix.get(i), mid);
            }

            if (count <= (n * m) / 2) 
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

    public static int countSmallerThanMid(ArrayList<Integer> row, int mid) {
        int low = 0, high = row.size() - 1;
        while (low <= high) {
            int m = (low + high) / 2;
            if (row.get(m) <= mid)
                low = m + 1;
            else
                high = m - 1;
        }

        return low;
    }

    public static void main(String[] args) {
        
    }
}
