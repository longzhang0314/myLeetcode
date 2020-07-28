package com.zl.leetcode.sort;

/**
 * 75.
 * Create by zhanglong on 2020/7/28
 */
public class SortColors_75 {

    public void sortColors(int[] nums) {
        int zero = -1, one = 0, two = nums.length - 1;
        while (one <= two) {
            if (nums[one] == 0) {
                // 与前面的元素交换一定可以保持当前等于1
                swap(nums, ++zero, one++);
            } else if (nums[one] == 1) {
                one++;
            } else if (nums[one] == 2) {
                // 与后面元素交互后不一定等于1，one不需要自增
                swap(nums, one, two--);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
