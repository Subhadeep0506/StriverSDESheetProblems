/*
 * Find the repeating and missing numbers
 */

package com.example.sdesheet.Day02;

public class RepeatAndMissing {
    int[] findTwoElement(int arr[], int n) {
        // code here
        long S = (n * (n+1) ) /2;
        long P = (n * (n+1) *(2*n+1) )/6;
        long missingNumber=0, repeating=0;
        
        int[] result = new int[2];
        
        for(int i=0;i<n; i++){
            S -= (long)arr[i];
            P -= (long)arr[i]*(long)arr[i];
        }
     
        missingNumber = (S + P/S)/2;

        repeating = missingNumber - S;
        
        result[0] = (int)repeating;
        result[1] = (int)missingNumber;

        return result;
    }
}
