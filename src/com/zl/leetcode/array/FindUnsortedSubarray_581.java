package com.zl.leetcode.array;

/**
 * 581. 最短无序连续子数组
 * Create by zhanglong on 2020/8/19
 */
public class FindUnsortedSubarray_581 {

    /**
     * 遍历两遍，找到不满足升序的左边界和右边界
     *
     * 优化为遍历一遍
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int left = 0, right = -1;
        int len = nums.length;
        int max = nums[0], min = nums[len - 1];
        for (int i = 0; i < len; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }

            if (nums[len - 1 - i] > min) {
                left = len - 1 - i;
            } else {
                min = nums[len - 1 - i];
            }
        }

        return right + 1 - left;
    }
}
