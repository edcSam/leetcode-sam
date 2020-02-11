/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.datastructure.binarytree;

/**
 * 二叉树的前序遍历。
 * 先输出根节点、再输出左子树、最后输出右子树。
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-04
 */
public class PreOrderTraversal {

    /**
     * 递归前序遍历。
     *
     * @param node
     * @return void
     * @author Yang Rong
     * @create 2020/2/4
     */
    public static void recursivePreOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // 处理逻辑。
        System.out.println(node.data);
        // 回溯逻辑。
        recursivePreOrderTraversal(node.leftChild);
        recursivePreOrderTraversal(node.rightChild);
    }

}
