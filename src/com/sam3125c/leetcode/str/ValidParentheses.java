/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.str;

import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Runtime: 11 ms, faster than 5.04% of Java online submissions for Valid Parentheses.
 * Memory Usage: 36.3 MB, less than 6.33% of Java online submissions for Valid Parentheses.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-12
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.equals("")) {
            return true;
        }

        String[] target = s.split("");
        if (isRight(target[0])) {
            return false;
        }

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < target.length; i++) {
            if (isLeft(target[i])) {
                stack.push(target[i]);
            } else if (!stack.empty() && match(stack.peek(), target[i])) {
                stack.pop();
            } else {
                return false;
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isLeft(String s) {
        if (s.equals("(") || s.equals("[") || s.equals("{")) return true;
        return false;
    }

    private boolean isRight(String s) {
        if (s.equals(")") || s.equals("]") || s.equals("}")) return true;
        return false;
    }

    private boolean match(String left, String right) {
        switch (left) {
            case "(":
                if (right.equals(")")) {
                    return true;
                }
                break;
            case "[":
                if (right.equals("]")) {
                    return true;
                }
                break;
            case "{":
                if (right.equals("}")) {
                    return true;
                }
                break;
        }
        return false;
    }

}
