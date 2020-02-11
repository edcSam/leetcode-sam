/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 219. Contains Duplicate II
 * Runtime: 9 ms, faster than 47.91% of Java online submissions for Contains Duplicate II.
 * Memory Usage: 44.6 MB, less than 18.42% of Java online submissions for Contains Duplicate II.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-24
 */
public class ContainsNearbyDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(len);

        for (int i = 0; i < len; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    /**
     * 缩短缓存区间，降低空间复杂度。
     * 整体距离始终保持在 k 以内，因此不需要再判断距离。
     *
     * @param nums
     * @param k
     * @return boolean
     * @author Yang Rong
     * @create 2019/10/25
     */
    public boolean standardAnswer(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) {
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

}
