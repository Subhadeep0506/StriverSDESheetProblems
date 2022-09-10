/*
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects
 * of the same color are adjacent, with the colors in the order red, white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 * 
 * Sol: We will use Dutch Flag Algorithm here
 */

package sdesheet.Day01;

public class SortColors {
    int[] nums = {2, 0, 2, 1, 1, 0};
    public static void main(String[] args) {
        SortColors obj = new SortColors();

        obj.sortColors(obj.nums);

        for (int num : obj.nums) {
            System.out.print(num + " ");
        }
    }

    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        int temp = 0;
        while (mid <= high) {
            switch (nums[mid]) {
                case 0: {
                    temp = nums[mid];
                    nums[mid] = nums[low];
                    nums[low] = temp;
                    mid++;
                    low++;
                    break;
                }

                case 1: {
                    mid++;
                    break;
                }

                case 2: {
                    temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;
                    high--;
                    break;
                }
            }
        }
    }
}
