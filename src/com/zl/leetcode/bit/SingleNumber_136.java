package com.zl.leetcode.bit;

/**
 * 136.
 * Create by zhanglong on 2020/8/19
 */
public class SingleNumber_136 {

    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
