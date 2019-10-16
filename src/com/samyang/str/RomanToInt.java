/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.samyang.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * Runtime: 5 ms, faster than 59.22% of Java online submissions for Roman to Integer.
 * Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Roman to Integer.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-10
 */
public class RomanToInt {

    public static Map<Character, Integer> plusMapping = new HashMap<>();
    public static Map<String, Integer> minusMapping = new HashMap<>();

    static {
        plusMapping.put('I', 1);
        plusMapping.put('V', 5);
        plusMapping.put('X', 10);
        plusMapping.put('L', 50);
        plusMapping.put('C', 100);
        plusMapping.put('D', 500);
        plusMapping.put('M', 1000);

        minusMapping.put("IV", 2);
        minusMapping.put("IX", 2);
        minusMapping.put("XL", 20);
        minusMapping.put("XC", 20);
        minusMapping.put("CD", 200);
        minusMapping.put("CM", 200);
    }

    public int romanToInt(String s) {
        int plus = 0;
        int minus = 0;
        int len = s.length();

        for (int i = 0; i < len - 1; i++) {
            plus += plusMapping.get(s.charAt(i));

            String minusString = s.substring(i, i + 2);
            if (minusMapping.containsKey(minusString)) {
                minus += minusMapping.get(minusString);
            }
        }

        plus += plusMapping.get(s.charAt(len - 1));

        return plus - minus;
    }

}
