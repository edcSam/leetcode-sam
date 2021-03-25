/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.datastructure.binarytree;

/**
 * 带深度的增强二叉树节点。
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-29
 */
public class StrengthenNode {

    public int depth;

    public TreeNode node;

    public StrengthenNode(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }

}
