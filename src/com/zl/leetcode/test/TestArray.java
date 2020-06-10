package com.zl.leetcode.test;

/**
 * Create by zhanglong on 2020/6/8
 */
public class TestArray {
    public static void main(String[] args) {

    }

    public int findDuplicate2(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int cnt = 0;
            for (int num : nums) {
                if (mid >= num) cnt++;
            }
            // 肯定在左边，包括mid
            if (cnt > mid) {
                right = mid;
            } else if (cnt <= mid) {
                left = mid + 1;
            }
        }
        return left;
    }


}
