package com.example.sdesheet.InfySamples;

public class GridPaths {
    public static void main(String[] args) {
        int n = 3;
        int[][] arr = {{1, 2}, {4, 3}, {2, 3}};

        System.out.println(findPath(n, arr));
    }

    public static int findPath(int n, int[][] arr) {
        int count = 0;
        int lastLargest = 0;
        
        int i = 0;
        while (i < n) {
            if (arr[i][0] < lastLargest && arr[i][1] < lastLargest)
                break;
            if (arr[i][0] > arr[i][1]) {
                count += arr[i][0];
                lastLargest = arr[i][0];
            }
            else {
                count += arr[i][1];
                lastLargest = arr[i][1];
            }
            i++;
        }

        return count;
    }
}
