package com.zl.leetcode.str;

/**
 * 647.
 * Create by zhanglong on 2020/7/30
 */
public class PalindromicSubstrings_647 {

    int res = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++) {
            // 单个中心点扩展
            expand(s, i, i);
            // 两个位置作为中心点扩展
            expand(s, i, i + 1);
        }
        return res;
    }

    private void expand(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            res++;
            start--;
            end++;
        }
    }
}
