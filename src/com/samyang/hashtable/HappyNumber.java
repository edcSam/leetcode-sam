/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.samyang.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 * Runtime: 2 ms, faster than 63.61% of Java online submissions for Happy Number.
 * Memory Usage: 33.6 MB, less than 10.60% of Java online submissions for Happy Number.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-09
 */
public class HappyNumber {

    /**
     * 不要将 n 转化为 String 来做。
     * 因为转化成 String 本质就是转化为一堆 char 数组，会进行一些数学计算，就重复了，O(time) 会超。
     * 直接在数学层面一步到位的进行 happy 运行即可。
     *
     * @param n
     * @return boolean
     * @author Yang Rong
     * @create 2019/10/29
     */
    public static boolean isHappy(int n) {
        Set<Integer> inLoop = new HashSet<>();

        int squareSum, remain;
        while (inLoop.add(n)) {
            squareSum = 0;
            while (n > 0) {
                // 每一次都通过取余数，处理个位数字。
                remain = n % 10;
                squareSum += Math.pow(remain, 2);
                // 平方计算累加后，通过除 10 抛弃小数，以保证上面每次处理个位数字时都是处理的目标位。
                n /= 10;
            }
            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }
        return false;
    }

}
