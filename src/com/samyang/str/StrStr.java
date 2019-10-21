/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.samyang.str;

/**
 * 28. Implement strStr()
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Implement strStr().
 * Memory Usage: 37.7 MB, less than 67.94% of Java online submissions for Implement strStr().
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-21
 */
public class StrStr {

    public static int strStr(String haystack, String needle) {
        int patternLen = needle.length();
        int mainLen = haystack.length();
        int patternHash = needle.hashCode();

        for (int i = 0; i < mainLen - patternLen + 1; i++) {
            String main = haystack.substring(i, i + patternLen);
            if (patternHash == main.hashCode()) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }

}
