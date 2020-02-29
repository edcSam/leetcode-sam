/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.tree;

import com.sam3125c.datastructure.binarytree.TreeNode;

/**
 * 979. Distribute Coins in Binary Tree
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Distribute Coins in Binary Tree.
 * Memory Usage: 38.6 MB, less than 82.14% of Java online submissions for Distribute Coins in Binary Tree.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-29
 */
public class DistributeCoinsInBinaryTree {

    private int moves = 0;

    public int distributeCoins(TreeNode root) {
        // 让所有金币平衡，然后统计走过的步数。
        balance(root);
        return moves;
    }

    /**
     * 要让一个节点平衡，需要节点扣留自己的一个金币数量，然后将多的给左子树及右子树。
     * 移动的步数，就是给左子树和给右子树的个数。
     * 谁给谁不一定，因此可能是负数。但是金币流量不变，取绝对值。
     *
     * @param node
     * @return int
     * @author Yang Rong
     * @create 2020/2/29
     */
    private int balance(TreeNode node) {
        // 空节点没有 balance，返回 0。
        if (node == null) return 0;
        int lb = balance(node.left);
        int rb = balance(node.right);
        // 可能是负数。但是金币流量不变，取绝对值。
        moves += Math.abs(lb) + Math.abs(rb);
        // 一个节点的 balance = 它的金币数量 - 1 + （给/被给）左子树的 balance + （给/被给）右子树的 balance
        return node.val - 1 + lb + rb;
    }

}
