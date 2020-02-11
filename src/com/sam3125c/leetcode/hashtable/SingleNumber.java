/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 136. Single Number
 * Runtime: 8 ms, faster than 22.20% of Java online submissions for Single Number.
 * Memory Usage: 39.6 MB, less than 96.30% of Java online submissions for Single Number.
 *
 * result ^=A[i]
 * ((2^2)^(1^1)^(4^4)^(5)) => (0^0^0^5) => 5
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-12
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int len = nums.length;
        int size = (int) (len / 0.75);
        Map<Integer, Integer> map = new HashMap<>(size);

        int count;
        int key;
        for (int num : nums) {
            key = num;
            count = map.getOrDefault(key, 0) + 1;
            map.put(key, count);
        }

        for (Map.Entry entry : map.entrySet()) {
            if ((int)entry.getValue() == 1) {
                return (int) entry.getKey();
            }
        }

        return 0;
    }

}
