package Day01;

public class NextPermutation {
    int[] nums = {1, 1, 5};
    public static void main(String[] args) {
        NextPermutation obj = new NextPermutation();
        obj.nextPermutation(obj.nums);

        for(int i: obj.nums) {
            System.out.print(i + " ");
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums.length <= 1 || nums == null)
            return;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]){
            i--;
        }
        
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i])
                j--;
            swap(nums, i, j);
        }
        
        reverse(nums, i + 1, nums.length - 1);
    }
    
    public void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
