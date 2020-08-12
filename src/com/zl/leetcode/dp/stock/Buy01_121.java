package com.zl.leetcode.dp.stock;

/**
 * dp[i][k][0 or 1]
 * i天数，k至多进行k次交易，1持有 0不持有  buy or sell只能有一个操作增加k值
 * dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + price[i])
 * dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - price[i])
 *
 * Create by zhanglong on 2020/8/12
 */
public class Buy01_121 {

    // k = 1
    public int maxProfit(int[] prices) {
        // dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][0][1] + price[i])
        // dp[i][1][1] = max(dp[i-1][1][1]. dp[i-1][0][0] - price[i])
        // 求dp[n-1][1][0]

        // k==1,状态压缩
        // dp[i][0] = max(dp[i-1][0], dp[i-1][1] + price[i])
        // dp[i][1] = max(dp[i-1][1], -price[i])

        // 继续压缩
        int n = prices.length;
        if (n == 0) return 0;
        int dp0 = 0;
        int dp1 = -prices[0];
        for (int i = 1; i < n; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, -prices[i]);
        }
        return dp0;
    }
}
