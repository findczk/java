package leetcode;

/**
 * 55. 跳跃游戏
 * @author dsx
 */
public class Solution55 {
//    public boolean canJump(int[] nums) {
//        int start = 0;
//        int end = 1;
//        int maxPos = 0;
//        while (start < end) {
//            for (int i = start; i < end; i++) {
//                maxPos = Math.max(maxPos, i + nums[i]);
//                if (maxPos >= nums.length - 1) {
//                    return true;
//                }
//            }
//
//            start = end;
//            end = maxPos + nums[maxPos];
//        }
//
//        return false;
//    }

    public boolean canJump(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] >= nums.length - 1) {
                return true;
            }
        }

        return false;
    }
}
