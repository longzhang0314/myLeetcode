package com.zl.leetcode.str;

/**
 * 409.
 * Create by zhanglong on 2020/7/29
 */
public class LongestPalindrome_409 {


    //a 97 A 65 0 48
    // 97 + 25 = 122, 122 - 65 + 1 = 58
    public int longestPalindrome(String s) {
        // a 97  A 65  a+25=122 122 - 65 + 1 = 122 - 64 = 58
        if (s == null || s.length() == 0) return 0;
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A']++;
        }

        int num = 0;
        for (int n : cnt) {
            // 偶数部分可得的回文串长度
            num += n / 2 * 2;
            // 如果存在奇数，全局只能有1个
            if ((n & 1) == 1 && (num & 1) == 0) num += 1;
        }
        // 奇数的判断也可以在此处
        // if (num < s.length()) num++;

        return num;
    }
}
