package com.zl.leetcode.dp.stock;

/**
 * 122. 交易次数不限
 * Create by zhanglong on 2020/8/12
 */
public class Buy02_122 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }

    public int maxProfit1(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int dp0 = 0;
        int dp1 = -prices[0];
        int dp2;
        for (int i = 1; i < n; i++) {
            dp2 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i]);
            dp0 = dp2;
        }
        return dp0;
    }
}
