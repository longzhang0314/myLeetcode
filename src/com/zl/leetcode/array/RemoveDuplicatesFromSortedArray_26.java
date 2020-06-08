package com.zl.leetcode.array;

/**
 * 删除排序数组中的重复项
 *
 * 不需要考虑数组中超出新长度的后面
 * 需要使用O(1)的空间复杂度
 */
public class RemoveDuplicatesFromSortedArray_26 {

    /**
     * 方法1：逐个遍历并赋值，遇到当前值后面有重复值的直接跳过
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || nums[i] != nums[i + 1]) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }

    /**
     * 方法2：快慢指针
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int slow = 0, fast = 1;
        while (fast < n) {
            if (nums[slow] != nums[fast]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
