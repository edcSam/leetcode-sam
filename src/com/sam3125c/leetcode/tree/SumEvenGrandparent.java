/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.tree;

import com.sam3125c.datastructure.binarytree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 1315. Sum of Nodes with Even-Valued Grandparent
 * Runtime: 5 ms, faster than 17.41% of Java online submissions for Sum of Nodes with Even-Valued Grandparent.
 * Memory Usage: 42.5 MB, less than 100.00% of Java online submissions for Sum of Nodes with Even-Valued Grandparent.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-01-28
 */
public class SumEvenGrandparent {

    public Set<TreeNode> results = new HashSet<>();

    public int sumEvenGrandparent(TreeNode root) {
        inOrderTraversal(root);
        int result = 0;
        for (TreeNode node : results) {
            result = result + node.val;
        }
        return result;
    }

    public void inOrderTraversal(TreeNode node){
        if (node == null) {
            return;
        }
        handleBiz(node);
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
    }

    public void handleBiz(TreeNode node){
        if (node.val % 2 != 0) {
            return;
        } else {
            if (node.left != null) {
                if (node.left.left != null) {
                    results.add(node.left.left);
                }
                if (node.left.right != null) {
                    results.add(node.left.right);
                }
            }
            if (node.right != null) {
                if (node.right.left != null) {
                    results.add(node.right.left);
                }
                if (node.right.right != null) {
                    results.add(node.right.right);
                }
            }
        }
    }

}
