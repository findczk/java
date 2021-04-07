package leetcode;

/**
 * @author dsx
 */
public class Solution9 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
