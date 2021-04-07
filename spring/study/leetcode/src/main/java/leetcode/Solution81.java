package leetcode;

/**
 * 81. 搜索旋转排序数组 II
 * @author dsx
 */
public class Solution81 {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) return true;

            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }

            //前半部分有序
            if (nums[left] < nums[mid]) {
                //target在前半部分
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {  //否则，去后半部分找
                    left = mid + 1;
                }
            } else {
                //后半部分有序
                //target在后半部分
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {  //否则，去后半部分找
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}
