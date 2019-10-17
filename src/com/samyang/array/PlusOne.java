/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.samyang.array;

import java.util.Arrays;

/**
 * 66. Plus One
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Plus One.
 * Memory Usage: 35.4 MB, less than 97.58% of Java online submissions for Plus One.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-17
 */
public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0) {
            return digits;
        }
        boolean up = false;
        for (int i = len - 1; i >= 0; i--) {
            if (up) {
                break;
            }

            digits[i] = digits[i] + 1;
            if (digits[i] == 10) {
                digits[i] = 0;
                if (i == 0) {
                    int[] newDigits = Arrays.copyOfRange(digits, 1, len + 2);
                    newDigits[0] = 1;
                    return newDigits;
                }
            } else {
                up = true;
            }
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] test = {9, 9, 9, 9};
        plusOne(test);
    }
}
