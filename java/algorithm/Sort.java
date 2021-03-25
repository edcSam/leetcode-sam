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

    /**
     * 选择排序。
     *
     * @param array
     * @return int[]
     * @author Yang Rong
     * @create 2020/2/27
     */
    public static int[] choiceSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i; j < len; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        return array;
    }

    /**
     * 归并排序。
     *
     * @param array
     * @return int[]
     * @author Yang Rong
     * @create 2020/3/3
     */
    public static int[] mergeSort(int[] array) {
        recursiveInMergeSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * 归并排序的递归部分。
     *
     * @param array
     * @param p
     * @param r
     * @return void
     * @author Yang Rong
     * @create 2020/3/3
     */
    private static void recursiveInMergeSort(int[] array, int p, int r) {
        // 无法进一步分解了。
        if (p >= r) return;
        // 分解逻辑，取中值。
        int q = p + (r - p) / 2;
        // 递归分解中值左半部分。
        recursiveInMergeSort(array, p, q);
        // 递归分解中值右半部分。
        recursiveInMergeSort(array, q + 1, r);
        // 有序合并左右部分。
        mergeInSortMerge(array, p, q, r);
    }

    /**
     * 归并排序的合并部分。
     *
     * @param array
     * @param p
     * @param q
     * @param r
     * @return void
     * @author Yang Rong
     * @create 2020/3/3
     */
    private static void mergeInSortMerge(int[] array, int p, int q, int r) {
        // 左半部分起始。
        int i = p;
        // 右半部分起始。
        int j = q + 1;
        // 临时数组相关。
        int k = 0;
        int[] tmp = new int[r - p + 1];

        // 左右半部的比较，从小到大放入临时数组。直到一个半部放完。
        while (i <= q && j <= r) {
            if (array[i] <= array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }

        // 假设 while 被 j > r 破坏，则未放完的是 i,q。
        // 如果并不是，则 j <= r，那么未放完的是 j,r。
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        // 确定后，继续放未放完的半部。
        while (start <= end) {
            tmp[k++] = array[start++];
        }

        // 将临时数组中数据，拷贝到原数组。
        for (int c = 0; c < r - p + 1; c++) {
            array[p + c] = tmp[c];
        }
    }

    /**
     * 快速排序。
     *
     * @param array
     * @return int[]
     * @author Yang Rong
     * @create 2020/3/3
     */
    public static int[] quickSort(int[] array) {
        recursiveInQuickSort(array, 0, array.length - 1);
        return array;
    }

    /**
     * 快速排序的递归部分。
     *
     * @param array
     * @param p
     * @param r
     * @return void
     * @author Yang Rong
     * @create 2020/3/3
     */
    private static void recursiveInQuickSort(int[] array, int p, int r) {
        // 无法进一步分区了。
        if (p >= r) return;
        // 获取逻辑，取得分区的下标。
        int q = partitionInQuickSort(array, p, r);
        // 递归分区小于分区下标的部分。
        recursiveInQuickSort(array, p, q - 1);
        // 递归分区大于分区下标的部分。
        recursiveInQuickSort(array, q + 1, r);
    }

    /**
     * 快速排序的分区部分。
     *
     * @param array
     * @param p
     * @param r
     * @return int
     * @author Yang Rong
     * @create 2020/3/3
     */
    private static int partitionInQuickSort(int[] array, int p, int r) {
        // 一般取 p,r 的最后一个元素为 pivot。
        int pivot = array[r];

        // 指针 i 用于维护大小区间的分界点，并且挂在大于 pivot 的第一个元素上。
        int i = p;
        // 指针 j 用于遍历。
        for (int j = p; j < r - 1; j++) {
            // 如果遍历的元素小于 pivot，则将该元素和 i 上元素互换。
            // 当 i 自增后，i 元素左边的元素都是小于 pivot 的。
            // 并且 i 继续保持挂在大于 pivot 的第一个元素上。
            if (array[j] < pivot) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }

        // 最后让 i 与 pivot 互换，让 pivot 去到真正分割大小区间的位置。
        array[r] = array[i];
        array[i] = pivot;

        //此时下标 i 即为 pivot 下标。
        return i;
    }
}
