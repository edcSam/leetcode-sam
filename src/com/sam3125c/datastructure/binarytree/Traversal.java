/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.datastructure.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的递归遍历。
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-04
 */
public class Traversal {

    /**
     * 递归前序遍历。
     *
     * @param node
     * @return void
     * @author Yang Rong
     * @create 2020/2/4
     */
    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // 处理逻辑。
        System.out.println(node.val);
        // 回溯逻辑。
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    /**
     * 递归中序遍历。
     *
     * @param node
     * @return void
     * @author Yang Rong
     * @create 2020/2/4
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // 左子树回溯逻辑。
        inOrderTraversal(node.left);
        // 处理逻辑。
        System.out.println(node.val);
        // 右子树回溯逻辑。
        inOrderTraversal(node.right);
    }

    /**
     * 递归后序遍历。
     *
     * @param node
     * @return void
     * @author Yang Rong
     * @create 2020/2/4
     */
    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        // 回溯逻辑。
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        // 处理逻辑。
        System.out.println(node.val);
    }

    /**
     * 深度优先遍历。
     *
     * @param node
     * @return void
     * @author Yang Rong
     * @create 2020/2/29
     */
    public static void depthFirstSearch(TreeNode node) {
        if (node == null) {
            return;
        }
        // 借助栈结构实现。
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        // 循环到栈为空。
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            // 处理逻辑。
            System.out.println(curr.val);
            // 先压右子树。
            if (curr.right != null) {
                stack.push(curr.right);
            }
            // 再压左子树。
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }

    /**
     * 广度优先遍历。
     *
     * @param node
     * @return void
     * @author Yang Rong
     * @create 2020/2/29
     */
    public static void breadthFirstSearch(TreeNode node) {
        if (node == null) {
            return;
        }
        // 借助队列结构实现。
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        // 循环到队列为空。
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            // 处理逻辑。
            System.out.println(curr.val);
            // 先入队左子树。
            if (curr.left != null) {
                queue.offer(curr.left);
            }
            // 再入队右子树。
            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
    }

}
