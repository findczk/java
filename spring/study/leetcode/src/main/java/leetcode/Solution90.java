package leetcode;

import java.util.*;

/**
 * 90. 子集 II
 * @author dsx
 */
public class Solution90 {
    Set<List<Integer>> result = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        for (int i = 0; i <= nums.length; i++) {
            dfs(list, new Stack<>(), i, 0);
        }
        return new ArrayList<>(result);
    }

    private void dfs(List<Integer> list, Stack<Integer> stack, int k, int start) {
        if (k == 0) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            stack.add(list.remove(i));
            dfs(list, stack, k - 1, start++);
            list.add(i, stack.pop());
        }
    }
}
