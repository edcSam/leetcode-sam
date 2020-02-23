/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 621. Task Scheduler
 * Time Limit Exceeded
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-17
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        // 改为工作列队容器。
        Queue<Character> tasksQueue = new LinkedList<>();
        for (char task : tasks) {
            tasksQueue.offer(task);
        }
        // 执行队列，用于缓存最近 n 个 cpu 周期的执行内容。
        Queue<Character> executeQueue = new LinkedList<>();
        // cpu 执行总数。
        int intervals = 0;
        // 转圈检查。
        int checkCycle = tasksQueue.size();

        // 执行到工作队列为空。
        while (!tasksQueue.isEmpty()) {
            char task = tasksQueue.poll();
            if (!executeQueue.contains(task)) {
                intervals += 1;
                // 若执行队列达到 n 个，则将队头任务出队，新执行任务入队尾。
                if (executeQueue.size() == n) {
                    executeQueue.poll();
                }
                executeQueue.offer(task);

                // 修正转圈检查长度。
                checkCycle = tasksQueue.size();
            } else {
                // 执行队列存在该任务，重新加入工作队列队尾。
                tasksQueue.offer(task);
                checkCycle -= 1;

                // 工作队列中没有满足执行要求的任务，加入 idle 到执行队列，直到挤出一个执行过的任务。
                if (checkCycle == 0) {
                    executeQueue.poll();
                    while (executeQueue.size() != n) {
                        executeQueue.offer('-');
                        intervals += 1;
                    }
                }
            }
        }

        return intervals;
    }

}
