package leetcode;

import java.util.*;

/**
 * 49. 字母异位词分组
 * @author dsx
 */
public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Character>, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            List<Character> characters = new ArrayList<>();
            for (char aChar : chars) {
                characters.add(aChar);
            }
            if (map.containsKey(characters)) {
                List<String> list = map.get(characters);
                list.add(strs[i]);
            }else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(characters, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
