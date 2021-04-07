package leetcode;

/**
 * 59. 螺旋矩阵 II
 * @author dsx
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int num = 1;
        int l = 0;
        int r = n - 1;
        int u = 0;
        int d = n - 1;
        while (true) {
            if (l > r) {
                break;
            }
            for (int i = l; i <= r; i++) {
                matrix[u][i] = num++;
            }
            u++;
            if (u > d) {
                break;
            }
            for (int i = u; i <= d; i++) {
                matrix[i][r] = num++;
            }
            r--;
            if (r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                matrix[d][i] = num++;
            }
            d--;
            if (d < u) {
                break;
            }
            for (int i = d; i >= u; i--) {
                matrix[i][l] = num++;
            }
            l++;
        }

        return matrix;
    }
}
