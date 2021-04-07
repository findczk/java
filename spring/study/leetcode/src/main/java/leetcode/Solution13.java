package leetcode;

/**
 * 下一个排列
 * @author dsx
 */
public class Solution13 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;

        int i = nums.length - 1;
        for (; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = nums.length - 1; j >= i; j--) {
                    if (nums[i-1] < nums[j]){
                        swap(nums,i - 1, j);
                        break;
                    }
                }
                reverse(nums, i, nums.length - 1);

                break;
            }
        }

        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
        }
    }

    private void reverse(int[] nums,int left,int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
