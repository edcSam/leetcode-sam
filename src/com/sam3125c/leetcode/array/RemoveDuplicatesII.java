/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.array;

/**
 * 80. Remove Duplicates from Sorted Array II
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted Array II.
 * Memory Usage: 41.8 MB, less than 5.26% of Java online submissions for Remove Duplicates from Sorted Array II.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-16
 */
public class RemoveDuplicatesII {

    public int removeDuplicates(int[] nums) {
        // 通 26. Remove Duplicates from Sorted Array 一样，引入快慢指针，原地遍历。
        // i 跟 index - 2 比较，不需要关注 index - 1。
        // 因为随着指针移动，在重复元素（大于 2 个）之间判断时候，只需要关注 index - 1 之后的。
        // 而在不同元素之间判断时，index - 1 始终会被移动。
        int index = 2 ;
        for(int i = 2; i < nums.length; i++){
            if(nums[i] != nums[index - 2]   ){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

}
