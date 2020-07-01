package com.zl.leetcode.test;

/**
 * Create by zhanglong on 2020/6/8
 */
public class TestArray {
    public static void main(String[] args) {

    }


    public boolean isMatch(String s, String p) {
        return match(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private boolean match(char[] s, char[] p, int sx, int px) {
        if (px == p.length) return sx == s.length;
        // process .
        boolean firstMatch = sx < s.length && (s[sx] == p[px] || p[px] == '.');

        if (p.length >= 2 && p[px] == '*') {
            // process *
            return match(s, p, sx, px + 2)
                    || match(s, p, sx + 1, px);
        }

        // process .
        return firstMatch && match(s, p, sx + 1, px + 1);
    }


}
