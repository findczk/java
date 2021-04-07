package leetcode;

/**
 * 32. 最长有效括号
 *
 * @author dsx
 */
public class Solution14 {
    //动态规划
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        int maxLength = 0;

        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '(') {
                dp[i] = 0;
            } else {
                if (i - dp[i - 1] - 2 >= 0 && s.charAt(i - dp[i - 1] - 2) == '(') {
                    dp[i] = 2 + dp[i - 1] + dp[i - dp[i - 1] - 2];
                }
            }
            if (dp[i] > maxLength) {
                maxLength = dp[i];
            }
        }

        return maxLength;
    }


    //暴力
//    public int longestValidParentheses(String s) {
//        if (s == null || s.length() == 0) return 0;
//        for (int i = s.length() / 2 * 2; i >= 0; i -= 2) {
//            for (int j = 0; j <= s.length() - i; j++) {
//                String str = s.substring(j, j + i);
//                while (str.contains("()")) {
//                    str = str.replace("()", "");
//                }
//                if (str.length() == 0) {
//                    return i;
//                }
//            }
//        }
//        return 0;
//    }

    //栈
//    public int longestValidParentheses(String s) {
//        if (s == null || s.length() == 0) return 0;
//        int maxLength = 0;
//        int length = 0;
//        Stack<Integer> stack = new Stack<>();
//        stack.push(-1);
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.push(i);
//            }else{
//                stack.pop();
//                if (stack.isEmpty()) {
//                    stack.push(i);
//                }else {
//                    length = i - stack.peek();
//                }
//            }
//
//            if (length > maxLength) {
//                maxLength = length;
//            }
//        }
//        return maxLength;
//    }
}
