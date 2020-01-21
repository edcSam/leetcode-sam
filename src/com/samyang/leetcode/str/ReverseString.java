/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.samyang.leetcode.str;

/**
 * 344. Reverse String
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse String.
 * Memory Usage: 51.1 MB, less than 69.23% of Java online submissions for Reverse String.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-22
 */
public class ReverseString {

    public static void reverseString(char[] s) {
        int len = s.length;
        int end = len / 2;

        char temp;
        int ri;
        for (int i = 0; i < end; i++) {
            ri = (len - 1) - i;
            temp = s[i];
            s[i] = s[ri];
            s[ri] = temp;
        }
    }

    public static void main(String[] args) {
       char[] test = {'h','e','l','l','o'};
       reverseString(test);
    }

}
