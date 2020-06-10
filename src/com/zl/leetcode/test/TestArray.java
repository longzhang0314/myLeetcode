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
            // 在[0, n)中先随便取一个值
            int mid = (left + right) >>> 1;
            int cnt = 0;
            for (int num : nums) {
                // 统计出小于等于当前mid值的个数
                if (num <= mid) cnt++;
            }
            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


}
