package Day03;

import java.util.*;

public class MajorityElementII {
  public List<Integer> majorityElement(int[] nums) {
        int num1 = Integer.MIN_VALUE, num2 = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;
        
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        
        for (int num: nums) {
            if (num == num1)
                count1++;
            else if (num == num2)
                count2++;
            else if (count1 == 0) {
                num1 = num;
                count1++;
            }
            else if (count2 == 0) {
                num2 = num;
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        
        for (int num: nums) {
            if (num == num1) 
                count1++;
            else if (num == num2)
                count2++;
        }
        
        if (count1 > n / 3)
            res.add(num1);
        if (count2 > n / 3)
            res.add(num2);
        
        return res;
    }
}