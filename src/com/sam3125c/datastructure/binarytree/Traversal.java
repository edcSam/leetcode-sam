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
        // 借助栈结构实现深度遍历。
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
     * 带深度的深度优先遍历。
     *
     * @param node
     * @return void
     * @author Yang Rong
     * @create 2020/2/29
     */
    public static void depthFirstSearchWithDepth(TreeNode node) {
        if (node == null) {
            return;
        }
        StrengthenNode sNode = new StrengthenNode(node, 1);
        // 借助栈结构实现深度遍历。
        Stack<StrengthenNode> stack = new Stack<>();
        stack.push(sNode);
        // 循环到栈为空。
        while (!stack.isEmpty()) {
            StrengthenNode curr = stack.pop();
            // 处理逻辑。
            System.out.println(String.format("node val is %s, node depth is %s.", curr.node.val, curr.depth));
            // 先压右子树。
            if (curr.node.right != null) {
                stack.push(new StrengthenNode(curr.node.right, curr.depth + 1));
            }
            // 再压左子树。
            if (curr.node.left != null) {
                stack.push(new StrengthenNode(curr.node.left, curr.depth + 1));
            }
        }
    }

    /**
     * 深度遍历，并给出叶子节点之间的分界点。
     *
     * @param node
     * @return void
     * @author Yang Rong
     * @create 2020/2/29
     */
    public static void depthFirstSearchWithDepthV2(TreeNode node) {
        if (node == null) {
            return;
        }
        // 借助栈结构实现深度遍历。
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
            // 叶子节点。
            if (curr.left == null && curr.right == null) {
                System.out.println("current node is leaf node, node val is " + curr.val);
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

    /**
     * 带深度的广度优先遍历。
     *
     * @param node
     * @return void
     * @author Yang Rong
     * @create 2020/2/29
     */
    public static void breadthFirstSearchWithDepth(TreeNode node) {
        if (node == null) {
            return;
        }
        StrengthenNode sNode = new StrengthenNode(node, 1);
        // 借助队列结构实现按层遍历。
        Queue<StrengthenNode> queue = new LinkedList<>();
        queue.offer(sNode);
        // 循环到队列为空。
        while (!queue.isEmpty()) {
            StrengthenNode curr = queue.poll();
            // 处理逻辑。
            System.out.println(String.format("node val is %s, node depth is %s.", curr.node.val, curr.depth));
            // 先入队左子树。
            if (curr.node.left != null) {
                queue.offer(new StrengthenNode(curr.node.left, curr.depth + 1));
            }
            // 再入队右子树。
            if (curr.node.right != null) {
                queue.offer(new StrengthenNode(curr.node.right, curr.depth + 1));
            }
        }
    }

    /**
     * 广度遍历，并给出层与层之间的分界点。
     *
     * @param node
     * @return void
     * @author Yang Rong
     * @create 2020/2/29
     */
    public static void breadthFirstSearchWithDepthV2(TreeNode node) {
        if (node == null) {
            return;
        }
        // 借助队列结构实现按层遍历。
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int depth = 0;
        // 循环到队列为空。
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 层与层之间的分界点。
            depth ++;
            System.out.println("current depth is " + depth);
            // 层内遍历。
            for (int i = 0; i < size; i++) {
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

}
