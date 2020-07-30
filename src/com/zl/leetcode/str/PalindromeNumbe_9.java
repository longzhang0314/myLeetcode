package com.zl.leetcode.str;

/**
 * 9.
 * Create by zhanglong on 2020/7/30
 */
public class PalindromeNumbe_9 {

    /**
     * 1. int to string
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        if (x < 10 && x >= 0) return true;
        if (x < 0) return false;
        String s = String.valueOf(x);
        return isPalindrome(s);
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }


    /**
     * 2. int judge
     *
     * judeg right, then compare left and right
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x >= 0 && x < 10) return true;
        if (x < 0 || x % 10 == 0) return false;
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }
}
