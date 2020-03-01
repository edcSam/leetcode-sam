/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * Runtime: 1 ms, faster than 99.90% of Java online submissions for Two Sum.
 * Memory Usage: 41.7 MB, less than 5.65% of Java online submissions for Two Sum.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-12
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            // 缓存遍历过的元素，供后续元素查找。
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
