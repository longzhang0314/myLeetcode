package com.zl.leetcode.binarysearch.demo;

/**
 * Create by zhanglong on 2020/6/8
 */
public class DemoLeft {

    public static void main(String[] args) {
        DemoLeft demoLeft = new DemoLeft();
        int[] nums = {2, 3, 5, 7};
        System.out.println(demoLeft.leftBound1(nums, 1));
    }

    /**
     * 查找排序数组等于target的第一个位置
     * 左侧边界
     * @param nums
     * @param target
     * @return
     */
    public int leftBound1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length; // right为开区间，不取值
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }

    /**
     * 查找排序数组等于target的第一个位置
     * 左侧边界 写法2
     * @param nums
     * @param target
     * @return
     */
    public int leftBound2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1; // right为闭区间，取值
        while (left <= right) { // 终止：left = right + 1
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        if (left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }


}
