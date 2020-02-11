/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.datastructure.binarytree;

/**
 * 二叉树的中序遍历。
 * 先输出左子树、再输出根节点、最后输出右子树。
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-04
 */
public class InOrderTraversal {

    /**
     * 递归中序遍历。
     *
     * @param node
     * @return void
     * @author Yang Rong
     * @create 2020/2/4
     */
    public static void recursiveInOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // 左子树回溯逻辑。
        recursiveInOrderTraversal(node.left);
        // 处理逻辑。
        System.out.println(node.val);
        // 右子树回溯逻辑。
        recursiveInOrderTraversal(node.right);
    }

}
