/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.datastructure.binarytree;

/**
 * 二叉树的后序遍历。
 * 先输出左子树、再输出右子树、最后输出根节点。
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-04
 */
public class PostOrderTraversal {

    /**
     * 递归后序遍历。
     *
     * @param node
     * @return void
     * @author Yang Rong
     * @create 2020/2/4
     */
    public static void recursivePostOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // 回溯逻辑。
        recursivePostOrderTraversal(node.left);
        recursivePostOrderTraversal(node.right);
        // 处理逻辑。
        System.out.println(node.val);
    }

}
