package com.zl.leetcode.dp;

/**
 * 279. 完全平方数
 * Create by zhanglong on 2020/8/19
 */
public class NumSquares_279 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
