/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.datastructure.binarytree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.sam3125c.datastructure.binarytree.TreeNode.createBinaryTree;
import static com.sam3125c.datastructure.binarytree.TreeNode.dismantlingBinaryTree;

/**
 * 二叉树数据结构相关测试。
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-04
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> input = new LinkedList<>(
                Arrays.asList(4, 2, 1, null, null, 3, null, null, 6, 5, null, null, 7));
        TreeNode treeNode = createBinaryTree(input);
        List<Integer> treeLinked = dismantlingBinaryTree(treeNode, new LinkedList<>());

        System.out.println("前序遍历：");
        Traversal.preOrderTraversal(treeNode);

        System.out.println("中序遍历：");
        Traversal.inOrderTraversal(treeNode);

        System.out.println("后序遍历：");
        Traversal.postOrderTraversal(treeNode);

        System.out.println("深度遍历：");
        Traversal.depthFirstSearch(treeNode);

        System.out.println("带深度的深度遍历：");
        Traversal.depthFirstSearchWithDepth(treeNode);

        System.out.println("叶子节点间隔的深度遍历：");
        Traversal.depthFirstSearchWithDepthV2(treeNode);

        System.out.println("广度遍历：");
        Traversal.breadthFirstSearch(treeNode);

        System.out.println("带深度的广度遍历：");
        Traversal.breadthFirstSearchWithDepth(treeNode);

        System.out.println("层层间隔的广度遍历：");
        Traversal.breadthFirstSearchWithDepthV2(treeNode);
    }

}
