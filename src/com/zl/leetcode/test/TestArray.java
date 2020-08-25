package com.zl.leetcode.test;

import java.util.HashSet;
import java.util.Set;

/**
 * Create by zhanglong on 2020/6/8
 */
public class TestArray {
    public static void main(String[] args) {
        System.out.println(multi(new int[]{1, 2, 3, 1}));

    }
    public static boolean multi(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) return true;
        }
        return false;
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
