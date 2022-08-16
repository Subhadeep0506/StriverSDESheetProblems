package com.example.sdesheet.Day08;

import java.util.Arrays;

public class MinimumPlatforms {
    static int findPlatform(int arr[], int dep[], int n) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int max = 1;
        int currPlat = 1;
        int i = 1, j = 0;
        while (i < n && j < n) {
            if (arr[i] > dep[j]) {
                currPlat--;
                j++;
            }
            else if (arr[i] < dep[j]) {
                currPlat++;
                i++;
            }
            
            if (currPlat > max)
                max = currPlat;
        }
        
        return max;
    }
}
