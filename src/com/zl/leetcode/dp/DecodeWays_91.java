package com.zl.leetcode.dp;

/**
 * 91.解码方法
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 计算解码方法总数
 * TODO
 * <p>
 * <p>
 * Create by zhanglong on 2020/6/15
 */
public class DecodeWays_91 {

    public static void main(String[] args) {
        DecodeWays_91 test = new DecodeWays_91();
        System.out.println(test.numDecodings2("12"));
    }

    /**
     * 方法1：递归+缓存
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.length() == 0) return 1;
        int[] memo = new int[s.length()];
        return helper(s, 0, memo);
    }

    private int helper(String s, int i, int[] memo) {
        if (i == s.length()) return 1;
        if (memo[i] != 0) return memo[i];
        int cnt = 0;
        if (s.charAt(i) != '0')
            cnt += helper(s, i + 1, memo);
        if (i + 2 <= s.length()
                && Integer.parseInt(s.substring(i, i + 2)) >= 10
                && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
            cnt += helper(s, i + 2, memo);
        }
        memo[i] = cnt;
        return cnt;
    }


    /**
     * @param s
     * @return
     */
    public int numDecodings2(String s) {
        if (s.length() == 0) return 1;
        int[] opt = new int[s.length() + 1];
        opt[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0')
                opt[i] += opt[i - 1];
            if (i > 1 && i < s.length()
                    && Integer.parseInt(s.substring(i - 1, i + 1)) >= 10
                    && Integer.parseInt(s.substring(i - 1, i + 1)) <= 26)
                opt[i] += opt[i - 2];
        }
        return opt[s.length()];
    }


}
