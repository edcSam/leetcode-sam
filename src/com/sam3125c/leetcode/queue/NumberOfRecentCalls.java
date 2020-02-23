/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 933. Number of Recent Calls
 * Runtime: 19 ms, faster than 97.67% of Java online submissions for Number of Recent Calls.
 * Memory Usage: 45.8 MB, less than 100.00% of Java online submissions for Number of Recent Calls.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-17
 */
public class NumberOfRecentCalls {

    public Queue<Integer> queue;

    public NumberOfRecentCalls() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }

}
