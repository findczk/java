package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author dsx
 */
public class Solution4 {
    Set<String> set = new HashSet<>();
    public List<String> generateParenthesis(int n) {
        t(n - 1, "()");
        return new ArrayList<>(set);
    }

    private void t(int n, String res) {
        if (n <= 0) {
            set.add(res);
            return;
        }
        for (int i = 0; i < res.length() / 2 + 1; i++) {
            t(n - 1, res.substring(0, i) + "()" + res.substring(i));
        }
    }

}
