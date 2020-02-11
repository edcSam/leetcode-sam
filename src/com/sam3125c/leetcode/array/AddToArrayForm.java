/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.sam3125c.leetcode.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 989. Add to Array-Form of Integer
 * Runtime: 42 ms, faster than 29.02% of Java online submissions for Add to Array-Form of Integer.
 * Memory Usage: 40.7 MB, less than 100.00% of Java online submissions for Add to Array-Form of Integer.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-17
 */
public class AddToArrayForm {

    public static List<Integer> addToArrayForm(int[] A, int K) {
        // transfer K to integer array B.
        String ks = Integer.toString(K);
        int bLen = ks.length();
        int[] B = new int[bLen];
        for (int i = 0; i < bLen; i++) {
            B[i] = ks.charAt(i) - '0';
        }

        // length judge logic for loop.
        int aLen = A.length;
        int[] result;
        if (aLen > bLen) {
            result = addTwoArray(A, B);
        } else {
            result = addTwoArray(B, A);
        }

        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    public static int[] addTwoArray(int[] big, int[] small) {
        int plus = big.length - small.length;
        for (int i = small.length - 1; i >= 0; i--) {
            big[i + plus] = big[i + plus] + small[i];
        }
        return handleCarry(big);
    }

    public static int[] handleCarry(int[] target) {

        for (int i = target.length - 1; i >= 0; i--) {
            if (i == 0 && target[i] > 9) {
                int[] newTar = new int[target.length + 1];
                System.arraycopy(target, 0, newTar, 1, target.length);
                target = newTar;
                target[0] = 1;
                target[1] = target[1] - 10;
            } else if (target[i] > 9) {
                target[i] = target[i] - 10;
                target[i - 1] = target[i - 1] + 1;
            }
        }

        return target;
    }

    public static void main(String[] args) {
        int[] test = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int t = 1;
        addToArrayForm(test, t);
    }

}
