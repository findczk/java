package leetcode;


/**
 * 45. 跳跃游戏 II
 * @author dsx
 */
public class Solution45 {

    //[2,3,1,1,5]
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        int res = 0;
        int maxPos = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPos = Math.max(maxPos, i + nums[i]);
            if (i == end) {
                end = maxPos;
                res++;
            }
        }


        return res;
    }

//    public int jump(int[] nums) {
//        if (nums == null || nums.length <= 1) return 0;
//
//        int ans = 0;
//        int end = 0;
//        int maxPos = 0;
//        for (int i = 0; i < nums.length - 1; i++)
//        {
//            maxPos = Math.max(nums[i] + i, maxPos);
//            if (i == end)
//            {
//                end = maxPos;
//                ans++;
//            }
//        }
//        return ans;
//    }


}
