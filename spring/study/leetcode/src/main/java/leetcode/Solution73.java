package leetcode;

/**
 * 73. 矩阵置零
 *
 * @author dsx
 */
public class Solution73 {
    //O(mn) 的额外空间
//    public void setZeroes(int[][] matrix) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        boolean[][] mark = new boolean[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == 0) {
//                    mark[i][j] = true;
//                }
//            }
//        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (mark[i][j]) {
//                    for (int k = 0; k < m; k++) {
//                        matrix[k][j] = 0;
//                    }
//                    for (int k = 0; k < n; k++) {
//                        matrix[i][k] = 0;
//                    }
//                }
//            }
//        }
//    }

    //O(m+n) 的额外空间
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (rows[i]) {
                for (int k = 0; k < n; k++) {
                    matrix[i][k] = 0;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            if (cols[j]) {
                for (int k = 0; k < m; k++) {
                    matrix[k][j] = 0;
                }
            }
        }
    }


}
