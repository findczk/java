package leetcode;

/**
 * 38. 外观数列
 * @author dsx
 */
public class Solution38 {
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; i++) {
            String str = "";
            int index = 0;
            for (int j = 0; j < res.length(); j++) {
                if (j + 1 >= res.length()) {
                    str += String.valueOf(j + 1 - index) + res.charAt(index);
                    break;
                } else if (res.charAt(j) != res.charAt(j + 1)) {
                    str += String.valueOf(j + 1 - index) + res.charAt(index);
                    index = j + 1;
                }
            }
            res = str;
        }

        return res;
    }
}
