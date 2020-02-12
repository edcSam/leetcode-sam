/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.tree;

import com.sam3125c.datastructure.binarytree.TreeNode;

/**
 * 938. Range Sum of BST
 * Runtime: 1 ms, faster than 55.28% of Java online submissions for Range Sum of BST.
 * Memory Usage: 48.4 MB, less than 67.44% of Java online submissions for Range Sum of BST.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-12
 */
public class RangeSumOfBST {

    public int sum = 0;

    public int rangeSumBST(TreeNode root, int L, int R) {
        inOrderTraversal(root, L, R);
        return sum;
    }

    public void inOrderTraversal(TreeNode node, int L, int R){
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, L, R);
        handleBiz(node, L, R);
        inOrderTraversal(node.right, L, R);
    }

    public void handleBiz(TreeNode node, int L, int R) {
        if (node.val >= L && node.val <= R) {
            sum += node.val;
        }
    }

}
