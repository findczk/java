package leetcode;

/**
 * 66. 加一
 * @author dsx
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {
        int one = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            one = (digits[i] + 1) / 10;
            digits[i] = (digits[i] + 1) % 10;
            if (one == 0) {
                break;
            }
        }

        if (one == 1) {
            int[] nums = new int[digits.length + 1];
            nums[0] = 1;
            for (int i = 1; i < nums.length; i++) {
                nums[i] = digits[i - 1];
            }
            return nums;
        }else {
            return digits;
        }
    }
}
