/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.sam3125c.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 12. Integer to Roman
 * Runtime: 5 ms, faster than 30.18% of Java online submissions for Integer to Roman.
 * Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Integer to Roman.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-11
 */
public class IntToRoman {

    public static Map<Integer, String> mapping = new HashMap<>(64);

    static {
        mapping.put(0, "");
        mapping.put(1, "I");
        mapping.put(2, "II");
        mapping.put(3, "III");
        mapping.put(4, "IV");
        mapping.put(5, "V");
        mapping.put(6, "VI");
        mapping.put(7, "VII");
        mapping.put(8, "VIII");
        mapping.put(9, "IX");
        mapping.put(10, "X");
        mapping.put(20, "XX");
        mapping.put(30, "XXX");
        mapping.put(40, "XL");
        mapping.put(50, "L");
        mapping.put(60, "LX");
        mapping.put(70, "LXX");
        mapping.put(80, "LXXX");
        mapping.put(90, "XC");
        mapping.put(100, "C");
        mapping.put(200, "CC");
        mapping.put(300, "CCC");
        mapping.put(400, "CD");
        mapping.put(500, "D");
        mapping.put(600, "DC");
        mapping.put(700, "DCC");
        mapping.put(800, "DCCC");
        mapping.put(900, "CM");
        mapping.put(1000, "M");
        mapping.put(2000, "MM");
        mapping.put(3000, "MMM");
    }

    public static String intToRoman(int num) {
        String string = Integer.toString(num);
        int len = string.length();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int each = (string.charAt(i) - '0') * (int) Math.pow(10, len - 1 - i);
            result.append(mapping.get(each));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(IntToRoman.intToRoman(10));
        System.out.println(IntToRoman.intToRoman(101));
        System.out.println(IntToRoman.intToRoman(1000));
    }

}
