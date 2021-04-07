package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 77. 组合
 * @author dsx
 */
public class Solution77 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        dfs(list, new Stack<>(), k, 0,n);

        return result;
    }

    private void dfs(List<Integer> list, Stack<Integer> stack, int k,int start,int n) {
        if (k == 0) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            if (list.subList(i, list.size()).size() < k) {
                return;
            }
            stack.add(list.remove(i));
            dfs(list, stack, k - 1, start++, n);
            list.add(i, stack.pop());
        }
    }
}
