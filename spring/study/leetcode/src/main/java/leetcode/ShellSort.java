package leetcode;

/**
 * @author dsx
 */
public class ShellSort {
    public void sort(int[] nums) {
        int len = nums.length;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                int j = i;
                int current = nums[i];
                while (j-gap >=0 && nums[j-gap] > current) {
                    nums[j] = nums[j-gap];
                    j -= gap;
                }
                nums[j] = current;
            }
        }
    }
}
