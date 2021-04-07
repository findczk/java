package leetcode;

/**
 * @author dsx
 */
public class Solution3 {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        if (s.length() == 0) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[0][j] = dp[0][j - 2];
                }
            }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)) {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

//    public boolean isMatch(String s, String p) {
//        if (s == null || p == null) return false;
//        if (p.startsWith("*")) return false;
//        int sLength = s.length();
//        int pLength = p.length();
//        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
//        dp[0][0] = true;
//        for (int j = 1; j < pLength + 1; j++) {
//            if (p.charAt(j - 1) == '*') dp[0][j] = dp[0][j - 2];
//        }
//        for (int i = 1; i < sLength + 1; i++) {
//            for (int j = 1; j < pLength + 1; j++) {
//                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
//                    dp[i][j] = dp[i - 1][j - 1];
//                } else if (p.charAt(j - 1) == '*') {
//                    if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
//                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
//                    }else {
//                        dp[i][j] = dp[i][j - 2];
//                    }
//                }
//            }
//        }
//
//        return dp[sLength][pLength];
//    }
}
