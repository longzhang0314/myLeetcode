package com.zl.leetcode.str;

import java.util.HashMap;
import java.util.Map;

/**
 * 242.
 * Create by zhanglong on 2020/7/29
 */
public class ValidAnagram_242 {

    public static void main(String[] args) {

    }

    /**
     * 1.
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        int[] dict = new int[26];
        for (char a : s.toCharArray()) {
            dict[a - 'a']++;
        }

        for (char b : t.toCharArray()) {
            dict[b - 'a']--;
        }

        for (int n : dict) {
            if (n != 0) return false;
        }
        return true;
    }

    /**
     * 2.
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram2(String s, String t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        for (char a : s.toCharArray()) {
            map1.getOrDefault(a, map1.getOrDefault(a, 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for (char b : t.toCharArray()) {
            map2.getOrDefault(b, map1.getOrDefault(b, 0) + 1);
        }

        return map1.equals(map2);
    }
 }
