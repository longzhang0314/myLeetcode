package com.zl.leetcode.dp;

/**
 * 152
 * Create by zhanglong on 2020/8/19
 */
public class MaxProduct_152 {
    private int max(int i, int j, int k) {
        int max = i;
        if (j > max) max = j;
        if (k > max) max = k;
        return max;
    }
    private int min(int i, int j, int k) {
        int min = i;
        if (j < min) min = j;
        if (k < min) min = k;
        return min;
    }

    /**
     * method1: brute dp
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int curMax = nums[0];
        int curMin = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int subMax = curMax * nums[i];
            int subMin = curMin * nums[i];
            curMax = max(subMax, subMin, nums[i]);
            curMin = min(subMax, subMin, nums[i]);
            res = Math.max(curMax, res);
        }
        return res;
    }


    /**
     * method 2: O(1) dp
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        // dp[i][0] - 考察到第i个数时最大值(不一定放入第i个数)
        int[][] dp = new int[2][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = i & 1;
            int y = (i - 1) & 1;
            dp[x][0] = max(dp[y][0] * nums[i], dp[y][1] * nums[i], nums[i]);
            dp[x][1] = min(dp[y][0] * nums[i], dp[y][1] * nums[i], nums[i]);
            res = Math.max(res, dp[x][0]);
        }
        return res;
    }











}
