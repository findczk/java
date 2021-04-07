package leetcode;

/**
 * @author dsx
 */
public class Solution16 {

    //[1,2,3,4,4,5,5,6,7]
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            if (nums[l] == target && nums[r] == target) return new int[]{l, r};
            int mid = (l + r) / 2;
            if (target < nums[mid]) {
                r = mid - 1;
            } else if (target > nums[mid]) {
                l = mid + 1;
            }else {
                if (target > nums[l]) {
                    l = l + 1;
                }
                if (target < nums[r]) {
                    r = r - 1;
                }
            }
        }

        return new int[]{-1, -1};
    }
}
