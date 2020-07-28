package com.zl.leetcode.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by zhanglong on 2020/7/28
 */
public class TestSort {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Integer frequencyKey : frequencyMap.keySet()) {
            Integer frequency = frequencyMap.get(frequencyKey);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(frequencyKey);
        }

        int[] res = new int[k];
        int cnt = 0;
        foreign:
        for (int i = buckets.length - 1; i > 0; i++) {
            if (buckets[i] == null) continue;
            for (Integer ele : buckets[i]) {
                if (cnt == k) break foreign;
                res[cnt++] = ele;
            }
        }
        return res;
    }
}
