/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.str;

/**
 * 14. Longest Common Prefix
 * Runtime: 1 ms, faster than 74.43% of Java online submissions for Longest Common Prefix.
 * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Longest Common Prefix.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-17
 */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        } else if (len == 1) {
            return strs[0];
        } else {
            String pattern = strs[0];
            for (int i = 1; i < len; i++) {
                pattern = compare(pattern, strs[i]);
                if ("".equals(pattern)) {
                    break;
                }
            }
            return pattern;
        }
    }

    public static String compare(String a, String b) {
        int len = Math.min(a.length(), b.length());
        int i = 0;
        for (; i < len; i++) {
            if (a.charAt(i) - b.charAt(i) != 0) {
                break;
            }
        }
        return a.substring(0, i);
    }

    public static void main(String[] args) {
        String[] test = {"adaf", "gfs"};
        System.out.println("[" + longestCommonPrefix(test) + "]");
    }

}
