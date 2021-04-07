package leetcode;

/**
 * 52. N皇后 II
 * @author dsx
 */
public class Solution52 {
    public int totalNQueens(int n) {
        //等于0时表示格子能使用
        int[] cells = new int[n * n];
        return solveNQueens(cells, 0, n);
    }

    private int solveNQueens(int[] cells,int start,int n) {
        int res = 0;
        if (start == n * n) {
            return 1;
        }

        for (int i = start; i < start + n; i++) {
            if (cells[i] == 0) {
                remark(cells, start, n, i, 1);
                res += solveNQueens(cells, start + n, n);
                remark(cells, start, n, i, -1);
            }
        }
        return res;
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
