package com.zl.leetcode.dp;

/**
 * 10. 正则表达式匹配
 * <p>
 * TODO
 * <p>
 * 待匹配串如果是abc，模式串是abcd，表示匹配不成功
 * Create by zhanglong on 2020/6/15
 */
public class RegularExpressionMatching_10 {

    public static void main(String[] args) {
        RegularExpressionMatching_10 test = new RegularExpressionMatching_10();
        System.out.println(test.isMatch("abc", "abcde"));
    }

    /**
     * 暴力递归1
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;

        boolean firstMatch = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        // process *
        if (p.length() > 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) // 匹配0个
                    || (firstMatch && isMatch(s.substring(1), p)); // 匹配多个
        }

        return firstMatch && isMatch(s.substring(1), p.substring(1));
    }


    /**
     * 暴力递归2
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        return match(s.toCharArray(), p.toCharArray(), 0, 0);
    }
    private boolean match(char[] s, char[] p, int sx, int px) {
        if (px == p.length) return sx == s.length;
        boolean firstMatch = sx < s.length && (s[sx] == p[px] || p[px] == '.');

        if (p.length >= 2 && p[px + 1] == '*') {
            // process *
            return match(s, p, sx, px + 2) // 匹配0个
                    || match(s, p, sx + 1, px); // 匹配多个
        }

        return firstMatch && match(s, p, sx + 1, px + 1);
    }
}
