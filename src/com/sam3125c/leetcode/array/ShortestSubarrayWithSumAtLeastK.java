/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

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

    public static int shortestSubarray(int[] A, int K) {
        // 区间合，一般需要考虑前缀合。
        // 若先做出前缀合 S，则 A3 - A10 的合就是 S10 - S2。
        int[] sum = new int[A.length + 1];
        int curSum = 0;
        for (int i = 0; i < A.length; i++) {
            curSum += A[i];
            sum[i + 1] = curSum;
        }

        Deque<Integer> deque = new LinkedList<>();
        deque.offer(0);
        int shortest = -1;
        for (int i = 1; i < sum.length; i++) {
            while (!deque.isEmpty() && sum[deque.peekLast()] >= sum[i]) {
                // 前面一个 index 的前缀合大于后面一个 index 的前缀合。
                // 说明这个 index 对应的值是负数或零。
                // 这个 index 可以被忽略，一定不是我们需要的值。
                deque.pollLast();
            }

            while (!deque.isEmpty() && sum[i] - sum[deque.peekFirst()] >= K) {
                // 循坏直到区间合不大于等于 K 为止。
                if (shortest == -1) shortest = i - deque.pollFirst();
                else shortest = Math.min(shortest, i - deque.pollFirst());
            }
            deque.offerLast(i);
        }

        return shortest;
    }

}
