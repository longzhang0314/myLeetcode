package com.zl.leetcode.binarysearch;

/**
 * 69. x 的平方根
 *
 *  x 是非负整数
 *  返回类型是整数，结果只保留整数的部分，小数部分将被舍去
 * Create by zhanglong on 2020/6/9
 */
public class Sqrtx_69 {

    public static void main(String[] args) {
        Sqrtx_69 test = new Sqrtx_69();
        System.out.println(test.mySqrt(2147395599));
    }

    /**
     * 二分查找  注意使用long类型，防止相乘后超出范围导致损失精度
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        int y = x / 2;
        long left = 0, right = y;
        while (left <= right) {
            long mid = (left + right) >>> 1;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid > x) {
                right = mid - 1;
            } else if (mid * mid < x) {
                if ((mid + 1) * (mid + 1) > x) {
                    return (int)mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }


    /**
     * 2. 推荐解法，不越界
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x <= 1) return x;
        int left = 1, right = x;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (sqrt < mid) {
                right = mid - 1;
            } else if (sqrt > mid) {
                left = mid + 1;
            }
        }
        return right;
    }
}
