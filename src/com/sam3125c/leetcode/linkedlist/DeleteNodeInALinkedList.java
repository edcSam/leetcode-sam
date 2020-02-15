/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.linkedlist;

import com.sam3125c.datastructure.linkedlist.ListNode;

/**
 * 237. Delete Node in a Linked List
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a Linked List.
 * Memory Usage: 40.8 MB, less than 5.09% of Java online submissions for Delete Node in a Linked List.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-15
 */
public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        while (node.next != null) {
            node.val = node.next.val;
            // 技巧：
            // 若不提前一个节点拿到尾节点的 next 空判断，就无法尾节点上一个节点的 next 指针，就无法赋值 null。
            // 若仅仅让尾节点变量赋值 null 是没用的，对链表本身没有影响。必须要让尾节点上一个节点的 next 指针为 null 才行。
            if (node.next.next == null) {
                node.next = null;
            } else {
                node = node.next;
            }
        }
    }

}
