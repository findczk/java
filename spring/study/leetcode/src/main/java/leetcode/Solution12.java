package leetcode;

import java.util.*;

/**
 * @author dsx
 */
public class Solution12 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordLen = words[0].length();
        int len = words.length * wordLen;
        for (int i = 0; i <= s.length() - len; ) {
            String str = s.substring(i, i + len);
            for (String word : words) {
                int length = str.length();
                int k = 0;
                while (k < str.length()) {
                    if (str.substring(k, k + wordLen).equals(word)) {
                        str = str.substring(0, k) + str.substring(k + wordLen);
                        break;
                    }
                    k += wordLen;
                }
                if (length == k) {
                    break;
                }
            }
            if (str.length() == 0){
                result.add(i);
                i += wordLen;
            }else {
                i++;
            }
        }

        return result;
    }




}
