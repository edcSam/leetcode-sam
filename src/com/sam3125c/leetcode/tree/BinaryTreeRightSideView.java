/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.tree;

import com.sam3125c.datastructure.binarytree.TreeNode;

import java.util.*;

/**
 * 199. Binary Tree Right Side View
 * Runtime: 2 ms, faster than 14.79% of Java online submissions for Binary Tree Right Side View.
 * Memory Usage: 38.8 MB, less than 5.88% of Java online submissions for Binary Tree Right Side View.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-29
 */
public class BinaryTreeRightSideView {

    public List<Integer>  rightSideView(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }
        StrengthenNode sNode = new StrengthenNode(node, 1);
        Map<Integer, Integer> resultMap = new HashMap<>();
        // 借助队列结构实现按层遍历。
        Queue<StrengthenNode> queue = new LinkedList<>();
        queue.offer(sNode);
        // 循环到队列为空。
        while (!queue.isEmpty()) {
            StrengthenNode curr = queue.poll();
            // 处理逻辑。
            resultMap.put(curr.depth, curr.node.val);
            // 先入队左子树。
            if (curr.node.left != null) {
                queue.offer(new StrengthenNode(curr.node.left, curr.depth + 1));
            }
            // 再入队右子树。
            if (curr.node.right != null) {
                queue.offer(new StrengthenNode(curr.node.right, curr.depth + 1));
            }
        }
        return new ArrayList<Integer>(resultMap.values());
    }

    /**
     * 带深度的增强节点。
     *
     * @author Yang Rong
     * @version 1.0
     * @email samyang3125c@gmail.com
     * @create 2020-02-29
     */
    class StrengthenNode {
        int depth;
        TreeNode node;

        StrengthenNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
}
