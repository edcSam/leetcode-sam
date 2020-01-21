/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.samyang.leetcode.array;

/**
 * 80. Remove Duplicates from Sorted Array II
 * Runtime: 1 ms, faster than 72.92% of Java online submissions for Remove Duplicates from Sorted Array II.
 * Memory Usage: 37.1 MB, less than 100.00% of Java online submissions for Remove Duplicates from Sorted Array II.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-16
 */
public class RemoveDuplicatesII {

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;

        if (len == 1) {
            return len;
        }

        boolean flag = true;
        int j = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[j] && flag) {
                j++;
                nums[j] = nums[i];

                flag = false;
            } else if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];

                flag = true;
            }
        }

        return j + 1;
    }

    public static void main(String[] args) {
        int[] test = {0, 0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 4, 5, 6, 7, 7, 7, 7, 7};
        System.out.println(removeDuplicates(test));
    }

}
