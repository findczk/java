package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 51. N 皇后
 * @author dsx
 */
public class Solution51 {
    private List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        //等于0时表示格子能使用
        int[] cells = new int[n * n];
        String[] qStr = new String[n];
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < i; j++) {
                s += ".";
            }
            s += "Q";
            for (int j = i + 1; j < n; j++) {
                s += ".";
            }
            qStr[i] = s;
        }

        solveNQueens(new Stack<>(), qStr, cells, 0, n);
        return result;
    }

    private void solveNQueens(Stack<String> stack,String[] qArr,int[] cells,int start,int n) {
        if (stack.size() == n) {
            result.add(new ArrayList<>(stack));
            return;
        }

        for (int i = start; i < start + n; i++) {
            if (cells[i] == 0) {
                remark(cells, start, n, i, 1);
                stack.add(qArr[i % n]);
                solveNQueens(stack,qArr, cells, start + n, n);
                stack.pop();
                remark(cells, start, n, i, -1);
            }
        }
    }

    //标记格子
    private void remark(int[] cells, int start, int n, int q,int m) {
        for (int i = start; i < cells.length; i++) {
            int k = (i - start) / n;
            int mod = i % n;
            if (k == 0 || mod == q - start || mod == q - start + k || mod == q - start - k) {
                cells[i] += m;
            }
        }
    }
}
