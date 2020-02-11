/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.tree;

import com.sam3125c.datastructure.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1302. Deepest Leaves Sum
 * Runtime: 9 ms, faster than 6.78% of Java online submissions for Deepest Leaves Sum.
 * Memory Usage: 42.7 MB, less than 100.00% of Java online submissions for Deepest Leaves Sum.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-11
 */
public class DeepestLeavesSum {

    public int deepest = 0;
    public int temp = 0;
    public int result = 0;

    public Map<TreeNode, Integer> nodes = new HashMap<>();

    public int deepestLeavesSum(TreeNode root) {
        inOrderTraversal(root);
        for (Map.Entry<TreeNode, Integer> node : nodes.entrySet()) {
            if (node.getValue() == deepest) {
                result = result + node.getKey().val;
            }
        }
        return result;
    }

    public void inOrderTraversal(TreeNode node){
        temp ++;
        if (node == null) {
            temp --;
            if (deepest < temp) {
                deepest = temp;
            }
            return;
        }
        inOrderTraversal(node.left);
        nodes.put(node, temp);
        inOrderTraversal(node.right);
        temp --;
    }

}
