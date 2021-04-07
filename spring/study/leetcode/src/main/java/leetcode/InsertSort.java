package leetcode;

/**
 * @author dsx
 */
public class InsertSort {
    public void sort(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;

        for (int i = 1; i < nums.length; i++) {
            int preIndex = i - 1;
            int current = nums[i];
            while (preIndex >= 0 && nums[preIndex] > current) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = current;
        }
    }
}
