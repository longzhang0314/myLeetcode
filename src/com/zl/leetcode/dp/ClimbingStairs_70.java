package com.zl.leetcode.dp;

/**
 * 70. 爬楼梯
 *
 * 重复性：f(n) = f(n-1) + f(n-2)
 *
 * TODO
 * 进阶1：可以走1步，2步，3步
 * 进阶2：且相邻步伐数不能相同
 * Create by zhanglong on 2020/6/15
 */
public class ClimbingStairs_70 {

    public static void main(String[] args) {
        ClimbingStairs_70 test = new ClimbingStairs_70();
        System.out.println(test.climbStairs2(1));
    }

    /**
     * 方法1：暴力递归
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        return climbStairs(n - 1) + climbStairs(n - 2);
    }


    /**
     * 方法2：缓存
     * @param n
     * @return
     */
    int[] lru;
    public int climbStairs2(int n) {
        if (n <= 2) return n;
        lru = new int[n + 1];
        lru[0] = 1;
        lru[1] = 1;
        lru[2] = 2;
        return helper(n);
    }

    private int helper(int n) {
        if (lru[n] != 0) return lru[n];
        return helper(n - 1) + helper(n - 2);
    }

    /**
     * 方法3：递推：一维数组
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if (n <= 2) return n;
        int[] opt = new int[n + 1];
        opt[1] = 1;
        opt[2] = 2;
        for (int i = 3; i <= n; i++) {
            opt[i] = opt[i - 1] + opt[i - 2];
        }
        return opt[n];
    }

    /**
     * 方法4：递推：有限常量
     * @param n
     * @return
     */
    public int climbStairs4(int n) {
        if (n <= 2) return n;
        int f1, f2, f3;
        f1 = 1;
        f2 = 2;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f2;
    }




}
