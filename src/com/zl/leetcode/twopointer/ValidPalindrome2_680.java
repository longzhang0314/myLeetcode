package com.zl.leetcode.twopointer;

/**
 * 680. 可以删除一个字符，判断是否是回文串
 * Create by zhanglong on 2020/7/27
 */
public class ValidPalindrome2_680 {

    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return valid(s, i, j - 1) || valid(s, i + 1, j);
            }
        }
        return true;
    }

    private boolean valid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }


}
