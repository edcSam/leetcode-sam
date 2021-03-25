/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.datastructure.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树节点。
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-04
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     * 利用链表创建一个二叉树。
     *
     * @param input
     * @return com.sam3125c.datastructure.binarytree.TreeNode
     * @author Yang Rong
     * @create 2020/2/4
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        TreeNode node = null;
        Integer data = input.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(input);
            node.right = createBinaryTree(input);
        }
        return node;
    }

    /**
     * 将二叉树拆成一个链表。
     *
     * @param root
     * @param result
     * @return java.util.List<java.lang.Integer>
     * @author Yang Rong
     * @create 2020/2/29
     */
    public static List<Integer> dismantlingBinaryTree(TreeNode root, List<Integer> result) {
        if (root == null) {
            result.add(null);
            return null;
        }

        result.add(root.val);
        dismantlingBinaryTree(root.left, result);
        dismantlingBinaryTree(root.right, result);
        return result;
    }

}
