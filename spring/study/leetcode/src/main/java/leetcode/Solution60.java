package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 60. 排列序列
 *
 * @author dsx
 */
public class Solution60 {
    public String getPermutation(int n, int k) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i + "");
        }

        return getPermutation(list, n, k);
    }

    private String getPermutation(List<String> list, int n, int k) {
        if (k == 1) {
            return String.join("", list);
        }
        int m = factorial(--n);
        int index = k / m;
        if (k % m == 0) index--;
        k -= index * m;

        return list.remove(index) + getPermutation(list, n, k);
    }

    private int factorial(int number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }

}
