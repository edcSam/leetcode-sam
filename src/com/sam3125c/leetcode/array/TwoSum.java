/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.sam3125c.leetcode.array;

/**
 * 1. Two Sum
 * Runtime: 25 ms, faster than 22.57% of Java online submissions for Two Sum.
 * Memory Usage: 37.3 MB, less than 98.95% of Java online submissions for Two Sum.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-12
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i = 0; i < nums.length; i ++) {
            for(int j = i +1; j < nums.length; j ++) {
                if((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

}
