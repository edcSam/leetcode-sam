/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.linkedlist;

import com.sam3125c.datastructure.linkedlist.ListNode;

import java.util.Stack;

/**
 * 21. Merge Two Sorted Lists
 * Runtime: 1 ms, faster than 20.54% of Java online submissions for Merge Two Sorted Lists.
 * Memory Usage: 38.5 MB, less than 19.53% of Java online submissions for Merge Two Sorted Lists.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-15
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 用栈合并有序链表，减少指针难度。
        Stack<ListNode> stack = new Stack<>();
        // 在一个链表为空之前，需要比较大小，按顺序入栈。
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                stack.add(l1);
                l1 = l1.next;
            } else {
                stack.add(l2);
                l2 = l2.next;
            }
        }
        // 找出此时不为空的链表，不用比较，全部顺序入栈。
        if (l1 == null) {
            while (l2 != null) {
                stack.add(l2);
                l2 = l2.next;
            }
        } else {
            while (l1 != null) {
                stack.add(l1);
                l1 = l1.next;
            }
        }
        // 弹出数据，制作新的有序链表。注意指针，最后要返回头节点。
        // 最后返回的链表大小顺序，也影响着数据结构的选择：数组或栈。
        ListNode newHead = null;
        while (!stack.empty()) {
            ListNode node = stack.pop();
            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }

}
