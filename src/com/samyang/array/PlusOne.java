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

    /**
     * 解题思路与逻辑是正确的，但是我的写法对比起最佳解法而言太复杂了。
     * 注意两个问题：
     * 1.不要用标志位，在不进位的时候就可以直接返回。而我想着跳出 for loop，因此用了标志位，以达到末尾 return。
     * 2.也正是由于「1」，目标数组每一个元素的进位的情况需要进行判断，从而以新的数组，新的 return 语句返回。
     * 实际上如果「1」做正确了，for loop 自然结束，就表示每一位进位。
     * 这时新建数组，第一位赋值 1 就可以。（这种情况是类似「999」情况）。这样也避免了数组拷贝。
     *
     * @param digits
     * @return int[]
     * @author Yang Rong
     * @create 2019/10/17
     */
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
