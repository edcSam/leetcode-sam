/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.samyang.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * Runtime: 22 ms, faster than 5.06% of Java online submissions for Roman to Integer.
 * Memory Usage: 37.3 MB, less than 70.12% of Java online submissions for Roman to Integer.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-10
 */
public class RomanToIntV2 {

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

        plusMapping.put('O', 4);
        plusMapping.put('P', 9);
        plusMapping.put('Q', 40);
        plusMapping.put('R', 90);
        plusMapping.put('S', 400);
        plusMapping.put('T', 900);

        minusMapping.put("IV", 2);
        minusMapping.put("IX", 2);
        minusMapping.put("XL", 20);
        minusMapping.put("XC", 20);
        minusMapping.put("CD", 200);
        minusMapping.put("CM", 200);
    }

    public static String preHandle(String s) {
        return s.replaceAll("IV", "O").replaceAll("IX", "P")
                .replaceAll("XL", "Q").replaceAll("XC", "R")
                .replaceAll("CD", "S").replaceAll("CM", "T");
    }

    public static int calculate(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += plusMapping.get(s.charAt(i));
        }
        return result;
    }

    public int romanToInt(String s) {
        return calculate(preHandle(s));
    }

}
