import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Test {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        
        System.out.println("Max sum of subarray: " + maxSubArray(nums).toString());
    }

    public static List<Integer> maxSubArray(int[] nums) {
        int largestSum = nums[0];
        int lastLargestSum = 0;
        int length = nums.length;
        int lastElem = nums[0];

        List<Integer> result = new ArrayList<>();
        // Stack<Integer> result = new Stack<>();
        for(int i = 0; i < length; i++) {
            lastLargestSum += nums[i];
            if (lastLargestSum > largestSum){
                largestSum = lastLargestSum;
                lastElem = nums[i];
                result.add(nums[i]);
            }
            if (lastLargestSum < 0){
                lastLargestSum = 0;
                result.remove(lastElem);
            }
        }

        return result;
    }
}