/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 217. Contains Duplicate
 * Runtime: 11 ms, faster than 13.83% of Java online submissions for Contains Duplicate.
 * Memory Usage: 44.2 MB, less than 61.21% of Java online submissions for Contains Duplicate.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-24
 */
public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(16);

        int count;
        for (int i = 0; i < len; i++) {
            count = map.getOrDefault(nums[i], 0) + 1;
            if (count == 2) {
                return true;
            } else {
                map.put(nums[i], count);
            }
        }

        return false;
    }

    /**
     * sometimes, time cost: O(nlogn) < O(n).
     * space cost is O(1).
     *
     * @param nums
     * @return boolean
     * @author Yang Rong
     * @create 2019/10/24
     */
    public static boolean standardAnswer(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

}
