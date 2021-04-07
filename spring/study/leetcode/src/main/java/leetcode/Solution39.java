package leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * 39. 组合总和
 * @author dsx
 */
public class Solution39 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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

        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            deque.push(candidates[i]);

            dfs(candidates, target - candidates[i], i, deque);

            deque.poll();

        }
    }

}
