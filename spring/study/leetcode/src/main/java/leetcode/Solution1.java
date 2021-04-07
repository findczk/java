package leetcode;


import java.util.Stack;

/**
 * 有效的括号
 */
class Solution1 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && s.charAt(i) - stack.peek() > 0 && s.charAt(i) - stack.peek() < 3) {
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }

        return stack.empty();
    }

//    public boolean isValid(String s) {
//        while (s.contains("()")||s.contains("[]")||s.contains("{}")){
//            s = s.replace("()", "");
//            s = s.replace("[]", "");
//            s = s.replace("{}", "");
//        }
//
//        return s.equals("");
//    }

}