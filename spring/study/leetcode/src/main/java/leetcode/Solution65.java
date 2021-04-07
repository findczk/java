package leetcode;

/**
 * 65. 有效数字
 * @author dsx
 */
public class Solution65 {
    public boolean isNumber(String s) {
        if (s.length() ==0) return false;
        int start = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            start = 1;
        }
        if (s.length() - start < 1) {
            return false;
        }
        int point = 0;
        int num = 0;
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) == '.'){
                point++;
                if (point > 1) {
                    return false;
                }
            }else if(s.charAt(i) =='E' || s.charAt(i)=='e'){
                if (!isInteger(s.substring(i + 1))) {
                    return false;
                }else {
                    break;
                }
            }else if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            } else{
                num++;
            }
        }
        return num > 0;
    }

    private boolean isInteger(String s) {
        if (s.length() ==0) return false;
        int start = 0;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            start = 1;
        }
        if (s.length() - start < 1) {
            return false;
        }
        for (int i = start; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                return false;
            }
        }

        return true;
    }
}
