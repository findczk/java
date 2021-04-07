package leetcode;

/**
 * @author dsx
 */
public class Solution8 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int len = 1;
        for(int i = 1; i < nums.length; i++){
            if (nums[len - 1] != nums[i]) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }
}
