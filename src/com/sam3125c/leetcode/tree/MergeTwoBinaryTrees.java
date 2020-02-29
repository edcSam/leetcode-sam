/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.tree;

import com.sam3125c.datastructure.binarytree.TreeNode;

/**
 * 617. Merge Two Binary Trees
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Binary Trees.
 * Memory Usage: 41.9 MB, less than 17.28% of Java online submissions for Merge Two Binary Trees.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-29
 */
public class MergeTwoBinaryTrees {

    /**
     * 注意递归思想。
     *
     * @param t1
     * @param t2
     * @return com.sam3125c.datastructure.binarytree.TreeNode
     * @author Yang Rong
     * @create 2020/3/1
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

}
