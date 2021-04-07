package leetcode;

/**
 * 80. 删除排序数组中的重复项 II
 * @author dsx
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int num = nums[0];
        int count = 0;
        int index = -1;

        for (int i = 0; i < nums.length; i++) {
            if (num == nums[i]) {
                count++;
                if (count <= 2) {
                    index++;
                    nums[index] = num;
                }
            }else {
                num = nums[i];
                count = 1;
                index++;
                nums[index] = num;
            }
        }

        return index + 1;
    }
}
