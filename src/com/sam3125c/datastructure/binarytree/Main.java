/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.datastructure.binarytree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 二叉树数据结构相关测试。
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-04
 */
public class Main {

    /**
     * 利用数组创建一个二叉树。
     *
     * @param input
     * @return com.sam3125c.datastructure.binarytree.TreeNode
     * @author Yang Rong
     * @create 2020/2/4
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> input) {
        TreeNode node = null;
        if (input == null || input.isEmpty()) {
            return null;
        }
        Integer data = input.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(input);
            node.rightChild = createBinaryTree(input);
        }
        return node;
    }

    public static void main(String[] args) {
        LinkedList<Integer> input = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        TreeNode treeNode = createBinaryTree(input);

        System.out.println("前序遍历：");
        PreOrderTraversal.recursivePreOrderTraversal(treeNode);

        System.out.println("中序遍历：");
        InOrderTraversal.recursiveInOrderTraversal(treeNode);

        System.out.println("后序遍历：");
        PostOrderTraversal.recursivePostOrderTraversal(treeNode);
    }
}
