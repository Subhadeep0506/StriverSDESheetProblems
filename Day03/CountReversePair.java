package Day03;

import java.util.*;

public class CountReversePair {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    public int mergeSort(int[] nums, int low, int high) {
        int count = 0;
        if (low == high)
            return 0;
        int mid = low + (high - low) / 2;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += merge(nums, low, mid, high);
        
        return count;
    }
    
    public int merge(int[] nums, int low, int mid, int high) {
        int j = mid + 1;
        int count = 0;
        for (int i = low; i <= mid; i++) {
            while (j <= high && nums[i] > 2 *(long) nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        int left = low; 
        int right = mid + 1;
        ArrayList<Integer> temp = new ArrayList<>();
        
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right])
                temp.add(nums[left++]);
            else
                temp.add(nums[right++]);
        }
        
        while (left <= mid) {
            temp.add(nums[left++]);
        }
        
        while (right <= high) {
            temp.add(nums[right++]);
        }
        
        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
        
        return count;
    }
}
