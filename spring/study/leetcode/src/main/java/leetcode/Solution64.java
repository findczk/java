package leetcode;

/**
 * 64. 最小路径和
 * @author dsx
 */
public class Solution64 {
    //暴力解法(超时)
//    int min = -1;
//    public int minPathSum(int[][] grid) {
//        dfs(grid, grid.length - 1, grid[0].length - 1, 0);
//        return min;
//    }
//
//    private void dfs(int[][] grid, int m, int n, int sum) {
//        sum += grid[m][n];
//        if (min != -1 && min < sum) {
//            return;
//        }
//        if (m == 0 && n == 0) {
//            min = sum;
//            return;
//        }
//        if (m > 0) {
//            dfs(grid, m - 1, n, sum);
//        }
//        if (n > 0) {
//            dfs(grid, m, n - 1, sum);
//        }
//    }

    //动态规划
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(grid[i][j] + dp[i - 1][j], grid[i][j] + dp[i][j - 1]);
            }
        }

        return dp[m-1][n-1];
    }
}
