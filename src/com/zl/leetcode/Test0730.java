package com.zl.leetcode;

/**
 * Create by zhanglong on 2020/7/30
 */
public class Test0730 {
    public static void main(String[] args) {

    }

    int res = 0;
    public int cnt(String s) {
        if (s == null || s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++) {
            expand(s, i, i);
            expand(s, i, i + 1);
        }
        return res;
    }

    private void expand(String s, int start, int end) {
        for (int i = 0; i < s.length(); i++) {
            if (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                res++;
                start--;
                end++;
            }
        }
    }
}
