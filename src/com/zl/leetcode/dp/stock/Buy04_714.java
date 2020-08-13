package com.zl.leetcode.dp.stock;

/**
 * 714. 股票买卖带手续费
 * Create by zhanglong on 2020/8/12
 */
public class Buy04_714 {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        if (n == 0) return 0;
        int dp0 = 0;
        int dp1 = -prices[0] - fee;
        int dp2;
        for (int i = 1; i < n; i++) {
            dp2 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i] - fee);
            dp0 = dp2;
        }
        return dp0;
    }
}
