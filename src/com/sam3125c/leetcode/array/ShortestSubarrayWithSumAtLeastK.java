/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.array;

import java.util.Arrays;

/**
 * 862. Shortest Subarray with Sum at Least K
 * Time Limit Exceeded
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-23
 */
public class ShortestSubarrayWithSumAtLeastK {
    public int shortestSubarray(int[] A, int K) {
        int l = A.length;
        for (int i = 1; i <= l; i++) {
            for (int j = 0; j <= l - i; j++) {
                int sum = 0;
                int[] a = Arrays.copyOfRange(A, j, j + i);
                for (int temp : a) {
                    sum += temp;
                }
                if (sum >= K) {
                    return i;
                }
            }
        }
        return -1;
    }
}
