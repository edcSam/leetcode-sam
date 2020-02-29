/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.tree;

import com.sam3125c.datastructure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 * Runtime: 1 ms, faster than 80.92% of Java online submissions for Binary Tree Right Side View.
 * Memory Usage: 38.4 MB, less than 5.88% of Java online submissions for Binary Tree Right Side View.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-29
 */
public class BinaryTreeRightSideView {

    public List<Integer>  rightSideView(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        // 借助队列结构实现。
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int depth = 0;
        // 循环到队列为空。
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode curr = null;
            // 层内遍历。
            for (int i = 0; i < size; i++) {
                curr = queue.poll();
                // 先入队左子树。
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                // 再入队右子树。
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            // 层与层分界点。
            result.add(curr.val);
        }
        return result;
    }

}
