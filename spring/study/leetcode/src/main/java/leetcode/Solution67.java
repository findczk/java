package leetcode;

/**
 * 67. 二进制求和
 * @author dsx
 */
public class Solution67 {
    public String addBinary(String num1, String num2) {
        String sum = "";
        int ten = 0;
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        do {
            int a = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int b = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            int c = a + b + ten;
            if (c >= 2) {
                ten = 1;
                c = c - 2;
            } else {
                ten = 0;
            }
            sum = c + sum;

            index1--;
            index2--;
        } while (index1 >= 0 || index2 >= 0);

        if (ten == 1) {
            sum = ten + sum;
        }

        return sum;
    }
}
