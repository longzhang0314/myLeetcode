package com.zl.leetcode.dp;

/**
 * 322. 零钱兑换
 * f(n) = min(amouont - (coin in coins)) + 1
 * TODO
 * <p>
 * <p>
 * Create by zhanglong on 2020/6/15
 */
public class CoinChange_322 {

    public static void main(String[] args) {
        CoinChange_322 test = new CoinChange_322();
        System.out.println(test.coinChange3(new int[]{1,2,5}, 11));
    }

    /**
     * 方法1：暴力递归
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        if (amount == 0) return 0;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) continue;
            int sub = coinChange(coins, amount - coin);
            if (sub == -1) continue;
            res = Math.min(res, sub + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 方法2：递归+缓存
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        int[] helper = new int[amount + 1];
        return helper(coins, amount, helper);
    }

    private int helper(int[] coins, int amount, int[] helper) {
        if (helper[amount] != 0) return helper[amount];
        if (amount == 0) return 0;
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) continue;
            int sub = helper(coins, amount - coin, helper);
            if (sub == -1) continue;
            res = Math.min(res, sub + 1);
        }
        helper[amount] = res;
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 方法3:DFS
     * @param coins
     * @param amount
     * @return
     */
    int res = Integer.MAX_VALUE;
    public int coinChange3(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        process(coins, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    private void process(int[] coins, int amount, int cur) {
        if (amount < 0) return;
        if (amount == 0) {
            res = Math.min(res, cur);
            return;
        }
        for (int coin : coins) {
            process(coins, amount - coin, cur + 1);
        }
    }

    /**
     * 方法4:DP
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange4(int[] coins, int amount) {
        Integer[] minDp = new Integer[amount + 1];
        minDp[0] = 0;
        for (int i = 1; i < minDp.length; i++) {
            int curMin = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin < 0) continue;
                if (minDp[i - coin] != null) curMin = Math.min(curMin, minDp[i - coin] + 1);
            }
            minDp[i] = curMin == Integer.MAX_VALUE ? null : curMin;
        }
        return minDp[amount] == null ? -1 : minDp[amount];
    }
}
