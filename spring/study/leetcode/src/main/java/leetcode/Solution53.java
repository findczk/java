package leetcode;

/**
 * 53. 最大子序和
 * @author dsx
 */
public class Solution53 {
    //[-2,1,-3,4,-1,2,1,-5,4]
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum < nums[i]) {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }

        return max;
    }
}
