package com.zl.leetcode.test;

/**
 * Create by zhanglong on 2020/6/8
 */
public class TestArray {
    public static void main(String[] args) {

    }

    int[] memo;
    public int decode(String s) {
        memo = new int[s.length()];
        return helper(s, 0);
    }

    private int helper(String s, int i) {
        if (i == s.length()) return 1;
        if (memo[i] != 0) return memo[i];
        int cnt = 0;
        if (s.charAt(i) != '0') cnt += helper(s, i + 1);
        if (i + 2 <= s.length()) cnt += helper(s, i + 2);
        return memo[i] = cnt;
    }


}
