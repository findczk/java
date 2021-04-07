package leetcode;

import java.util.*;

/**
 * 47. 全排列 II
 * @author dsx
 */
public class Solution47 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(int[] nums, List<Integer> item,int start) {
        if (item.size() == nums.length) {
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = start; i < item.size() + 1; i++) {
            int num = nums[item.size()];
            item.add(i, nums[item.size()]);
            if (item.size() < nums.length && nums[item.size()] == num) {
                dfs(nums, item, i + 1);
            }else {
                dfs(nums, item, 0);
            }
            item.remove(i);
        }
    }
}
