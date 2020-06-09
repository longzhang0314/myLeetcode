package com.zl.leetcode.binarysearch;

/**
 * 50. Pow(x, n)
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 * <p>
 * Create by zhanglong on 2020/6/9
 */
public class PowxN_50 {


    /**
     * x^n = (x^2)^(n/2)
     * 方法1：递归
     * 单独对负数处理转正数，正数
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        // 终止条件
        if (n == 0) return 1;
        if (n < 0 && n != Integer.MIN_VALUE) return 1 / myPow(x, -n);
        else if (n < 0) {
            return 1 / myPow(x, -(n + 1)) / x;
        }
        // 正数处理
        if ((n & 1) == 1) { // 奇次幂
            return x * myPow(x * x, n / 2);
        } else {
            return myPow(x * x, n / 2);
        }
    }

    /**
     * 方法2：循环，不断收敛，最终i收敛为1
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        double res = 1.0d;
        int i = n;
        while (i != 0) {
            if ((i & 1) == 1) { // 奇数单独乘x
                res *= x;
            }
            x *= x;
            i /= 2;
        }
        return n < 0 ? 1 / res : res;
    }

}
