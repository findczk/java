package leetcode;

/**
 * 43. 字符串相乘
 *
 * @author dsx
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        String res = "0";
        for (int i = 0; i < num1.length(); ) {
            int a = 0;
            int len = num1.length() - i;
            if (len > 8) {
                a = Integer.valueOf(num1.substring(i, i + 8));
                i += 8;
            } else {
                a = Integer.valueOf(num1.substring(i));
                i += len;
            }

            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                String c = a * b + "";
                if (!c.equals("0")) {
                    for (int k = 0; k < num1.length() + num2.length() - 1 - i - j; k++) {
                        c += "0";
                    }
                    res = sum(res, c);
                }
            }
        }
        return res;
    }


    private String sum(String num1, String num2) {
        String sum = "";
        int ten = 0;
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        do {
            int a = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int b = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            int c = a + b + ten;
            if (c >= 10) {
                ten = 1;
                c = c - 10;
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
