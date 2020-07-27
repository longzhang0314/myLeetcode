package com.zl.leetcode.twopointer;

/**
 * 633. 判断一个非负整数是否为两个整数的平方和。
 * Create by zhanglong on 2020/7/27
 */
public class SumOfSquareNumbers_633 {

    public boolean judgeSquareSum(int target) {
        if (target < 0) return false;
        int i = 0, j = (int) Math.sqrt(target);
        while (i <= j) {
            int res = i * i + j * j;
            if (res == target) {
                return true;
            } else if (res < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
