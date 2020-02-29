/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.tree;

import com.sam3125c.datastructure.binarytree.TreeNode;

/**
 * 112. Path Sum
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
 * Memory Usage: 39.6 MB, less than 5.88% of Java online submissions for Path Sum.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-03-01
 */
public class PathSum {

    /**
     * 注意递归思想。
     * 充分考虑边界条件，终止条件处理。
     *
     * @param root
     * @param sum
     * @return boolean
     * @author Yang Rong
     * @create 2020/3/1
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
