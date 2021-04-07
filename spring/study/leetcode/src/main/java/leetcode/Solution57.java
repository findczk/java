package leetcode;

/**
 * 58. 最后一个单词的长度
 * @author dsx
 */
public class Solution57 {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;

        int index = -1;

        for(int i = s.length() - 1 ; i >= 0 ; i--){
            if(index == -1 && s.charAt(i) != ' '){
                index = i;
            }
            if (index != -1 && s.charAt(i) == ' ') {
                return index - i;
            }
        }

        return index + 1;
    }
}
