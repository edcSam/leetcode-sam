/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.array;

/**
 * 27. Remove Element
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
 * Memory Usage: 38.1 MB, less than 5.05% of Java online submissions for Remove Element.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-16
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int tail = len - 1;
        // 引入一个指针，每次将末尾的元素，拷贝到要删除的元素位置上。
        for (int i = len - 1; i >= 0; i--) {
            if (nums[i] == val) {
                nums[i] = nums[tail];
                tail--;
            }
        }
        // 长度需要末尾下标 +1 。
        return tail + 1;
    }

}
