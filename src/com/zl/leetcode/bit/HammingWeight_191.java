package com.zl.leetcode.bit;

/**
 * 191.位1的个数
 * Create by zhanglong on 2020/8/19
 */
public class HammingWeight_191 {

    /**
     * method1: for loop and change bit
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int cnt = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) cnt++;

            mask <<= 1;
        }
        return cnt;
    }

    /**
     * method2: n & (n - 1) 可以将最低位1变为0，并保持其他位不变
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= (n - 1);
            cnt++;
        }
        return cnt;
    }

}
