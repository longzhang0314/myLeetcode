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


    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;

        boolean firstMatch = s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        // process *
        if (p.length() > 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2))
                    || (firstMatch && isMatch(s.substring(1), p));
        }

        return firstMatch && isMatch(s.substring(1), p.substring(1));
    }
}
