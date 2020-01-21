/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.samyang.leetcode.array;

/**
 * 26. Remove Duplicates from Sorted Array
 * Runtime: 1 ms, faster than 97.32% of Java online submissions for Remove Duplicates from Sorted Array.
 * Memory Usage: 39 MB, less than 99.47% of Java online submissions for Remove Duplicates from Sorted Array.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-16
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return len;
        }

        int j = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }

        return j + 1;
    }

    public static void main(String[] args) {
        int[] test = {0, 0, 1, 1, 2, 2, 2, 3};
        System.out.println(removeDuplicates(test));
    }

}
