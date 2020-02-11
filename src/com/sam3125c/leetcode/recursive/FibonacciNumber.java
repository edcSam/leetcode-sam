/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.recursive;

/**
 * 509. Fibonacci Number
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
 * Memory Usage: 36.2 MB, less than 5.51% of Java online submissions for Fibonacci Number.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-01
 */
public class FibonacciNumber {

    public static int fib(int N) {
        int preTwo = 0;
        if (N == preTwo) return preTwo;
        int preOne = 1;
        if (N == preOne) return preOne;
        int current = 0;
        for (int i = 2; i <= N; i++) {
            current = preOne + preTwo;
            preTwo = preOne;
            preOne = current;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(fib(1000));
    }

}
