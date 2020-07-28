package com.zl.leetcode.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 451.
 * Create by zhanglong on 2020/7/28
 */
public class SortCharactersByFrequency_451 {

    /**
     * 1. bucket sort
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return s;
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (Character key : frequencyMap.keySet()) {
            Integer frequency = frequencyMap.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            for (int i = 0; i < frequency; i++) {
                buckets[frequency].add(key);
            }
        }

        char[] res = new char[s.length()];
        int cnt = 0;
        foreign:
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] == null) continue;
            for (Character c : buckets[i]) {
                if (cnt == s.length()) break foreign;
                res[cnt++] = c;
            }
        }
        return new String(res);
    }
}
