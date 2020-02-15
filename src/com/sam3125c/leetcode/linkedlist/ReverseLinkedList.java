/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.linkedlist;

import com.sam3125c.datastructure.linkedlist.ListNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 206. Reverse Linked List V1
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
 * Memory Usage: 38.8 MB, less than 5.04% of Java online submissions for Reverse Linked List.
 *
 * 206. Reverse Linked List V2
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
 * Memory Usage: 39.2 MB, less than 5.04% of Java online submissions for Reverse Linked List.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-13
 */
public class ReverseLinkedList {

    public Queue<ListNode> queue = new LinkedList<>();

    public ListNode reverseListV1(ListNode head) {
        traversalListV1(head);
        ListNode newHead = null;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }

    public void traversalListV1(ListNode node) {
        if (node == null) {
            return;
        }
        queue.add(node);
        traversalListV1(node.next);
    }

    public ListNode reverseListV2(ListNode head) {
        return traversalListV2(null, head);
    }

    public ListNode traversalListV2(ListNode newHead, ListNode oldHead) {
        if (oldHead == null) {
            return newHead;
        }
        ListNode node = new ListNode(oldHead.val);
        node.next = newHead;
        return traversalListV2(node, oldHead.next);
    }

}
