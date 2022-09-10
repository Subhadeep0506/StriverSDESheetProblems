/*
 * Input Format:  A = [4, 2, 2, 6, 4] , B = 6
 * Result: 4
 * Explanation: The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2,
 * 6], [6]
 * 
 * Input Format: A = [5, 6, 7, 8, 9], B = 5
 * Result: 2
 * Explanation:The subarrays having XOR of their elements as 2 are [5] and [5, 6, 7, 8, 9]
 */

package sdesheet.Day04;

import java.util.*;

public class CountSubarraysWithXOR {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 6, 4};
        ArrayList<Integer> A = new ArrayList<Integer>();
        for (int num: arr)
            A.add(num);

        System.out.println(solve(A, 6));
    }
    public static int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int xor = 0;
        int length = A.size();
        for (int i = 0; i < length; i++) {
            xor = xor ^ A.get(i);
            if (map.containsKey(xor ^ B)) {
                count += map.get(xor ^ B);
            }
            if (xor == B) {
                count++;
            }
            if (map.containsKey(xor)) {
                map.put(xor, map.get(xor) + 1);
            }
            else {
                map.put(xor, 1);
            }
        }
        
        return count;
    }
}