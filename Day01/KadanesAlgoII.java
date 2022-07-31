package Day01;

public class KadanesAlgoII {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        nums = permute(nums);
        for(int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }

    public static int[] permute(int[] nums) {
        int sum = 0;
        int max = nums[0];
        int len = nums.length;
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            if (sum < 0){
                sum = 0;
                start = i;
                end = i;
                continue;
            }

            end = i;
        }

        int[] res = new int[(end - start) + 1];
        int j = 0;
        for(int i = start; i <= end; i++)
            res[j++] = nums[i];

        return res;
    }
}
