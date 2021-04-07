package leetcode;

import java.util.*;

/**
 * 40. 组合总和 II
 * @author dsx
 */
public class Solution40 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(candidates, target, 0, deque);
        return result;
    }


    private void dfs(int[] candidates, int target,int index, Deque<Integer> deque) {
        if (target == 0) {
            result.add(new ArrayList<>(deque));
            return;
        }

        Integer num = null;

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            //跳过相同的子节点
            if (Objects.equals(num, candidates[i])) {
                continue;
            }

            deque.push(candidates[i]);

            dfs(candidates, target - candidates[i], i + 1, deque);

            num = deque.poll();

        }
    }
}
