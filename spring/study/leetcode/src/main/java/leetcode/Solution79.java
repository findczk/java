package leetcode;

/**
 * 79. 单词搜索
 * @author dsx
 */
public class Solution79 {
    boolean[][] mark;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        mark = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0, m, n)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int wordIndex, int m, int n) {
        if (!mark[i][j] && board[i][j] == word.charAt(wordIndex)) {
            if (wordIndex == word.length()-1) {
                return true;
            }
            mark[i][j] = true;
            //向上
            if (i - 1 >= 0 && !mark[i - 1][j]) {
                if(dfs(board, word, i - 1, j, wordIndex + 1, m, n)){
                    return true;
                }
            }
            //向下
            if (i + 1 < m && !mark[i + 1][j]) {
               if (dfs(board, word, i + 1, j, wordIndex + 1, m, n)){
                   return true;
               }
            }
            //向左
            if (j - 1 >= 0 && !mark[i][j - 1]) {
               if (dfs(board, word, i, j - 1, wordIndex + 1, m, n)){
                   return true;
               }
            }
            //向右
            if (j + 1 < n && !mark[i][j + 1]) {
               if (dfs(board, word, i, j + 1, wordIndex + 1, m, n)){
                   return true;
               }
            }
            mark[i][j] = false;
        }

        return false;
    }
}
