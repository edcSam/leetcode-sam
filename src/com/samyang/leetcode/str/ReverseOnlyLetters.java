/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.samyang.leetcode.str;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 917. Reverse Only Letters
 * Runtime: 41 ms, faster than 5.10% of Java online submissions for Reverse Only Letters.
 * Memory Usage: 36.3 MB, less than 21.74% of Java online submissions for Reverse Only Letters.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-17
 */
public class ReverseOnlyLetters {

    public static String reverseOnlyLetters(String S) {
        int len = S.length();

        List<Character> resultList = new LinkedList<>();
        Map<Integer, Character> map = new TreeMap<>();
        for (int i = len - 1; i >= 0; i--) {
            char each = S.charAt(i);
            if (Character.isLetter(each)) {
                resultList.add(each);
            } else {
                map.put(i, each);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            resultList.add((int)entry.getKey(), (char)entry.getValue());
        }

        return resultList.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String test = "KH^,tteaTRgL$`P.n/C*11#!A$zVZU;8<b!4v`X%ypk+#'CpJc2)<0%^z0v+oGax+>@A:53dKo#,o5FT*Oz`6fgSpaDvzU:u$0g7";
        System.out.println(reverseOnlyLetters(test));
    }

}
