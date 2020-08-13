package com.zl.leetcode.dp.stock;

/**
 * 309
 * sell之后冷冻一天才能交易
 * Create by zhanglong on 2020/8/12
 */
public class Buy03_309 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][1] = Math.max(-prices[0], -prices[1]);
        dp[1][0] = Math.max(0, prices[1] - prices[0]);
        for (int i = 2; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public int maxProfit1(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int dp0 = 0;
        int dp1 = -prices[0];
        int pre0 = 0;
        int dp2;
        for (int i = 1; i < n; i++) {
            dp2 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, pre0 - prices[i]);
            pre0 = dp0;
            dp0 = dp2;
        }
        return dp0;
    }
}
