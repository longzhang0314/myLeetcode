package com.zl.leetcode.dp.stock;

/**
 * 123. 只能允许完成2笔交易
 * Create by zhanglong on 2020/8/13
 */
public class Buy05_123 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int k = Math.min(2, n >>> 1);
        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }

        for (int j = 1; j <= k; j++) {
            dp[0][j][0] = 0;
            dp[0][j][1] = -prices[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }
}
