/**
 * Yang Rong Individual Service
 * All Rights Reserved @2019
 */
package com.sam3125c.leetcode.array;

/**
 * 11. Container With Most Water
 * Runtime: 392 ms, faster than 5.01% of Java online submissions for Container With Most Water.
 * Memory Usage: 38.4 MB, less than 100.00% of Java online submissions for Container With Most Water.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-12
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i ++) {
            for (int j = i ; j < height.length; j ++) {
                int temp = height[i] > height[j] ? height[j] * (j -i) : height[i] * (j -i);
                if(temp > max) {
                    max = temp;
                }
            }
        }
        return max;
    }

}
