/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.linkedlist;

import com.sam3125c.datastructure.linkedlist.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 206. Reverse Linked List
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
 * Memory Usage: 38.8 MB, less than 5.04% of Java online submissions for Reverse Linked List.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-13
 */
public class ReverseLinkedList {

    public Queue<ListNode> queue = new LinkedList<>();

    public ListNode reverseList(ListNode head) {
        traversalList(head);
        ListNode newHead = null;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }

    public void traversalList(ListNode node) {
        if (node == null) {
            return;
        }
        queue.add(node);
        traversalList(node.next);
    }

}
