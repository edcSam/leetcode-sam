/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.linkedlist;

import com.sam3125c.datastructure.linkedlist.ListNode;

/**
 * 141. Linked List Cycle
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
 * Memory Usage: 40.7 MB, less than 5.71% of Java online submissions for Linked List Cycle.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-15
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        // 边界考虑，null 和 单节点。
        if (head == null || head.next == null) {
            return false;
        }
        // 快慢指针，追击问题。
        ListNode step1 = head;
        ListNode step2 = head;
        while(step1.next != null) {
            step1 = step1.next;
            if(step2.next == null || step2.next.next == null) {
                // 若快指针直接到了终点，说明无环。
                return false;
            }
            step2 = step2.next.next;
            if (step1 == step2) {
                // 快慢指针相遇，说明有环。
                return true;
            }
        }
        return false;
    }

}
