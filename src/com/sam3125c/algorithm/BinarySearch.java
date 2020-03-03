/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.algorithm;

/**
 * 二分搜索工具类。
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2020-03-02
 */
public class BinarySearch {

    /**
     * 利用循环实现的二分搜索。
     *
     * @param array
     * @param target
     * @return int
     * @author Yang Rong
     * @create 2020/3/2
     */
    public static int binarySearchWithLoop(int[] array, int target) {
        int len = array.length;
        int low = 0;
        int high = len - 1;
        // 循环搜索目标值，不断缩小搜索区间。
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > target) {
                high = mid - 1;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        // 未搜索到目标值，返回 -1。
        return -1;
    }

    /**
     * 利用递归实现的二分搜索。
     *
     * @param array
     * @param target
     * @return int
     * @author Yang Rong
     * @create 2020/3/2
     */
    public static int binarySearchWithRecursive(int[] array, int target) {
        return recursiveInBinarySearch(array, 0, array.length - 1, target);
    }

    /**
     * 递归二分搜索的递归逻辑。
     *
     * @param array
     * @param low
     * @param high
     * @param target
     * @return int
     * @author Yang Rong
     * @create 2020/3/2
     */
    private static int recursiveInBinarySearch(int[] array, int low, int high, int target) {
        // low 下标大于 high 下标，说明数组中找不到该元素，返回 -1。
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        // 递归搜索目标值，不断缩小搜索区间。
        if (array[mid] > target) return recursiveInBinarySearch(array, low, mid - 1, target);
        else if (array[mid] < target) return recursiveInBinarySearch(array, mid + 1, high, target);
        else return mid;
    }

}
