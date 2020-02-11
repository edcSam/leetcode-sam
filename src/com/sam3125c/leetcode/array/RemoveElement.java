/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.sam3125c.leetcode.array;

import java.util.Arrays;

/**
 * 27. Remove Element
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Remove Element.
 * Memory Usage: 35.6 MB, less than 100.00% of Java online submissions for Remove Element.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-16
 */
public class RemoveElement {

    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        Arrays.parallelSort(nums);
        int left = -1;
        for (int right = 0; right < len; right++) {
            if (nums[right] != val) {
                left++;
                nums[left] = nums[right];
            }
        }

        return left + 1;
    }

    public static void main(String[] args) {
        int[] test = {0, 1, 2, 2, 3, 0, 4, 2};
        int target = 2;
        System.out.println(removeElement(test, target));
    }

}
