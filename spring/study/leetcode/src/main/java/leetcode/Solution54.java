package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * @author dsx
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int l = 0;
        int r = matrix[0].length - 1;
        int u = 0;
        int d = matrix.length - 1;
        while (true) {
            if (l > r) {
                break;
            }
            for (int i = l; i <= r; i++) {
                res.add(matrix[u][i]);
            }
            u++;
            if (u > d) {
                break;
            }
            for (int i = u; i <= d; i++) {
                res.add(matrix[i][r]);
            }
            r--;
            if (r < l) {
                break;
            }
            for (int i = r; i >= l; i--) {
                res.add(matrix[d][i]);
            }
            d--;
            if (d < u) {
                break;
            }
            for (int i = d; i >= u; i--) {
                res.add(matrix[i][l]);
            }
            l++;
        }

        return res;
    }
}
