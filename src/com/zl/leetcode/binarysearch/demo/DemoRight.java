package com.zl.leetcode.binarysearch.demo;

/**
 * Create by zhanglong on 2020/6/8
 */
public class DemoRight {

    /**
     * 查找排序数组等于target的最后一个位置
     * 右侧边界
     * @param nums
     * @param target
     * @return
     */
    public int rightBound1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == 0) return -1;
        return nums[left - 1] == target ? left - 1 : -1;
    }

    /**
     * 查找排序数组等于target的最后一个位置
     * 右侧边界 写法2
     * @param nums
     * @param target
     * @return
     */
    public int rightBound2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (right == 0) return -1;
        return nums[right] == target ? right : -1;
    }
}
