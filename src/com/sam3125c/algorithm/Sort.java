/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.algorithm;

/**
 * 排序算法工具类。
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-02-26
 */
public class Sort {

    /**
     * 冒泡排序。
     *
     * @param array
     * @return int[]
     * @author Yang Rong
     * @create 2020/2/27
     */
    public static int[] bubbleSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }

    /**
     * 插入排序。
     *
     * @param array
     * @return int[]
     * @author Yang Rong
     * @create 2020/2/27
     */
    public static int[] insertSort(int[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int insert = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > insert) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = insert;
        }
        return array;
    }

}
