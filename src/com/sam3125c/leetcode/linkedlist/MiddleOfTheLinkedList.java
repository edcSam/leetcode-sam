/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.linkedlist;

import com.sam3125c.datastructure.linkedlist.ListNode;

/**
 * 876. Middle of the Linked List
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
 * Memory Usage: 37 MB, less than 7.84% of Java online submissions for Middle of the Linked List.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-15
 */
public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode one = head;
        ListNode two = head;

        int length1 = 0;
        while (one != null) {
            one = one.next;
            length1 += 1;
        }
        int middle = length1 / 2;

        int length2 = 0;
        while (two != null) {
            two = two.next;
            length2 += 1;

            if (length2 == middle) {
                break;
            }
        }
        return two;
    }
    
}
