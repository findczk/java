package leetcode;

/**
 * @author dsx
 */
public class Solution69 {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int min = 0;
        int max = x;
        while (max - min > 1) {
            int m = (max + min) / 2;
            if (x / m < m) {
                max = m;
            }else {
                min = m;
            }
        }
        return min;
    }
}
