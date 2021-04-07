package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 *
 * @author dsx
 */
public class Solution76 {
    private Map<Character, Integer> map = new HashMap<>();
    //滑动窗口
    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int indexL = 0;
        int indexR = 0;
        int ansL = 0;
        int ansR = 0;
        int len = Integer.MAX_VALUE;

        while (indexR < s.length()) {
            char c = s.charAt(indexR);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
            while (check() && indexL <= indexR) {
                if (indexR - indexL < len) {
                    len = indexR - indexL + 1;
                    ansL = indexL;
                    ansR = ansL + len;
                }
                char c1 = s.charAt(indexL);
                if (map.containsKey(c1)) {
                    map.put(c1, map.get(c1) + 1);
                }
                indexL++;
            }
            indexR++;
        }
        return s.substring(ansL, ansR);
    }

    private boolean check() {
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            Integer value = characterIntegerEntry.getValue();
            if (value > 0) {
                return false;
            }
        }
        return true;
    }
}
