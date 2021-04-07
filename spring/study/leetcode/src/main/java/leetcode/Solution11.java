package leetcode;



/**
 * 29. 两数相除
 * @author dsx
 */
public class Solution11 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        boolean mark = (dividend ^ divisor) < 0;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        int result = 0;

        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                result += 1 << i;
                a -= b << i;
            }
        }
        return mark ? -result : result;
    }
}
