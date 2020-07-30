package com.zl.leetcode.str;

/**
 * 696.
 * Create by zhanglong on 2020/7/30
 */
public class CountBinarySubstrings_696 {

    /**
     * 1. expand from center to left and right
     */
    int res = 0;
    public int countBinarySubstrings1(String s) {
        if (s == null || s.length() == 0) return 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                expand(s, i - 1, i);
            }
        }
        return res;
    }

    private void expand(String s, int start, int end) {
        char left = s.charAt(start);
        char right = s.charAt(end);
        while (start >= 0 && end < s.length() && s.charAt(start) == left && s.charAt(end) == right) {
            res++;
            start--;
            end++;
        }
    }


    /**
     * 2.two param saved 0 count and 1 count, when 0 count  > 1 count, res + 1;
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        int res = 0;
        int preLen = 0, curLen = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curLen++;
            } else {
                // swap，from and to
                preLen = curLen;
                curLen = 1;
            }

            if (preLen >= curLen) {
                res++;
            }
        }
        return res;
    }

}
