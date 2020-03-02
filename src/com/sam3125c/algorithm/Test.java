/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.algorithm;

/**
 * 二分搜索相关测试。
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-03-02
 */
public class Test {
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3};
        int[] test2 = {1, 7, 12, 33, 56, 77, 123, 354, 657, 865};

        System.out.println("循环二分搜索，结果应该为下标 index = 1：");
        System.out.println(BinarySearch.binarySearchWithLoop(test1, 2));
        System.out.println("循环二分搜索，结果应该为下标 index = 5：");
        System.out.println(BinarySearch.binarySearchWithLoop(test2, 77));

        System.out.println("递归二分搜索，结果应该为下标 index = 1：");
        System.out.println(BinarySearch.binarySearchWithRecursive(test1, 2));
        System.out.println("递归二分搜索，结果应该为下标 index = 5：");
        System.out.println(BinarySearch.binarySearchWithRecursive(test2, 77));
    }
}
