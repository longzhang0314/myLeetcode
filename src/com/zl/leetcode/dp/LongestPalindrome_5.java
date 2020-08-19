package com.zl.leetcode.dp;

/**
 * 5. longest palindrome string
 * Create by zhanglong on 2020/8/19
 */
public class LongestPalindrome_5 {

    /**
     * method1: brute force O(N^3)
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) return "";
        char[] cc = s.toCharArray();
        int n = cc.length;
        int maxLen = 1;
        int begin = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 > maxLen && isPalin(cc, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
    private boolean isPalin(char[] cc, int i, int j) {
        while (i < j) {
            if (cc[i++] != cc[j--]) return false;
        }
        return true;
    }



    /**
     * method2: 中心扩散 O(N^2)
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        int max = 1;
        String res = s.substring(0, 1);
        for (int i = 0; i < n - 1; i++) {
            String sin = center(s, i, i);
            String dou = center(s, i, i + 1);
            String maxLen = sin.length() > dou.length() ? sin : dou;
            if (maxLen.length() > max) {
                max = maxLen.length();
                res = maxLen;
            }
        }
        return res;
    }
    private String center(String s, int left, int right) {
        int i = left, j = right;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        return s.substring(i + 1, j);
    }

    /**
     * method3: dp
     * @param s
     * @return
     */
    public String longestPalindrome3(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        int maxLen = 1;
        int start = 0;
        // dp[i][j] = true, if dp[i+1][j-1] = true and s(i) = s(j)
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // 外层逐渐扩大
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        LongestPalindrome_5 test = new LongestPalindrome_5();
        String aaaa = test.longestPalindrome3("aaaa");
        System.out.println(aaaa);
    }
}
