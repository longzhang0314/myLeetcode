package com.zl.leetcode.dp;

/**
 * 300.
 * <p>
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * Create by zhanglong on 2020/8/19
 */
public class LengthOfLIS_300 {

    /**
     * method1: dp O(N^2)
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * method2 O(NlogN)
     * TODO
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return -1;
    }
}
