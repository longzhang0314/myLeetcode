package com.zl.leetcode.binarysearch;

import java.util.Arrays;

/**
 * 287.寻找重复数
 * 数组中有n+1个数，取值范围都在[1,n]
 *
 * 不能更改原数组（假设数组是只读的）。  - 排除排序
 * 只能使用额外的 O(1) 的空间。         - 排除hash表
 * 时间复杂度小于 O(n2) 。             - 排除暴力法
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * Create by zhanglong on 2020/6/9
 */
public class FindDuplicate_287 {


    /**
     * 方法1：二分查找
     *
     * 关键：与传统二分思维不同，最终找到的是值，而不是索引
     * TODO 回看
     * @param nums
     * @return
     */
    public int findDuplicate1(int[] nums) {
        // 一共nums.length个数，所以所有数的范围是[1, nums.length - 1]
        int left = 1, right = nums.length - 1;
        //
        while (left < right) {
            int mid = (left + right) >>> 1;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) cnt++;
            }
            // 如果小于等于mid的数严格大于mid个，肯定在左侧区间
            if (cnt > mid) {
                right = mid;
            } else { // 否则在另一个区间查找
                left = mid + 1;
            }
        }
        return left;
    }

}
