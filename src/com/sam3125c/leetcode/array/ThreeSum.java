/**
 * Yang Rong Individual Service
 * All Rights Reserved @2020
 */
package com.sam3125c.leetcode.array;

import java.util.*;

/**
 * 15. 3Sum
 * Runtime: 18 ms, faster than 94.05% of Java online submissions for 3Sum.
 * Memory Usage: 46.1 MB, less than 93.29% of Java online submissions for 3Sum.
 *
 * @author Yang Rong
 * @version 1.0
 * @email samyang3125c@gmail.com
 * @create 2019-10-14
 */
class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // 排序是遍历的基础，排完序才能引入 low、high 指针及它们的自增、减。
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                while (low < high) {
                    int curr = nums[i] + nums[low] + nums[high];
                    if (curr > 0) {
                        high--;
                    } else if (curr < 0) {
                        low++;
                    } else {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[low]);
                        ans.add(nums[high]);
                        result.add(ans);
                        // skip same result。
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        // 保存结果，并跳过同解后，双指针一同变化。
                        high--;
                        low++;
                    }
                }
            }
        }
        return result;
    }

}
