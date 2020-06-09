package com.zl.leetcode.binarysearch;

import java.util.Arrays;

/**
 * 287.寻找重复数
 * 数组中有n+1个数，取值范围都在[1,n]
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * Create by zhanglong on 2020/6/9
 */
public class FindDuplicate_287 {

    /**
     * 方法1：排序后遍历
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i+1]) return nums[i];
        }
        return -1;
    }

    /**
     * 方法2：二分查找
     * TODO 回看
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) cnt++;
            }
            // 如果小于等于mid的数  小于等于mid个，考虑右侧区间
            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
