package leetcode;

import java.util.Stack;

/**
 * 71. 简化路径
 * @author dsx
 */
public class Solution71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        stack.add("");
        for (String s : split) {
            if (!s.equals("") && !s.equals(".")) {
                if (s.equals("..")) {
                    if (stack.size() > 1) {
                        stack.pop();
                    }
                } else {
                    stack.add(s);
                }
            }
        }

        return stack.size() == 1 ? "/" : String.join("/", stack);
    }
}
