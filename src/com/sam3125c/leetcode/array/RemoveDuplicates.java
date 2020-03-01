/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.array;

/**
 * 26. Remove Duplicates from Sorted Array
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array.
 * Memory Usage: 41.5 MB, less than 17.02% of Java online submissions for Remove Duplicates from Sorted Array.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-16
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        // 边界条件处理。
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        // 引入快慢双指针，原地遍历。
        // i 为快指针，无论何时都加一；j 为慢指针，若 j 指向的元素跟 i 相同，那么 j 就不增加。
        // 很容易想象，j 与 i 中间的距离，就是重复元素的个数。
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }
        // 最后返回的下标，不需要再加 1 即可表示长度。
        // i++ 在 index++ 之后，最后一次 i++ 进不了循环。
        return index;
    }

}
