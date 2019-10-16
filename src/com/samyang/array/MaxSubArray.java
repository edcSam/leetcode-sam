/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.samyang.array;

/**
 * 53. Maximum Subarray
 * Runtime: 86 ms, faster than 5.04% of Java online submissions for Maximum Subarray.
 * Memory Usage: 56.7 MB, less than 5.16% of Java online submissions for Maximum Subarray.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-12
 */
public class MaxSubArray {

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        int max = nums[0];

        for (int i = 0; i < len; i++) {
            int temp = 0;
            for (int j = i; j < len; j++) {
                temp += nums[j];
                if (temp > max) {
                    max = temp;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] target = new int[]{-1};
        System.out.println(maxSubArray(target));
    }

}