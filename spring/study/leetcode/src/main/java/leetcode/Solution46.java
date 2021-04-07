package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author dsx
 */
public class Solution46 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(nums, new ArrayList<>());
        return result;
    }
    private void dfs(int[] nums, List<Integer> item) {
        if (item.size() == nums.length) {
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = 0; i < item.size() + 1; i++) {
            item.add(i, nums[item.size()]);
            dfs(nums, item);
            item.remove(i);
        }
    }
}
