package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 78. 子集
 * @author dsx
 */
public class Solution78 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        for (int i = 0; i <= nums.length; i++) {
            dfs(list, new Stack<>(), i, 0);
        }
        return result;
    }

    private void dfs(List<Integer> list, Stack<Integer> stack, int k,int start) {
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
