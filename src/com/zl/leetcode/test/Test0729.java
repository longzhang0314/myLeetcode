package com.zl.leetcode.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Create by zhanglong on 2020/7/29
 */
public class Test0729 {

    public static void main(String[] args) {
        String s = "cacaca";
        Test0729 test = new Test0729();

    }

    public int[] topKFrequent3(int[] nums, int k) {
        // frequency dict
        Map<Integer, Integer> frequenceMap = new HashMap<>();
        for (int n : nums) {
            frequenceMap.put(n, frequenceMap.getOrDefault(n, 0) + 1);
        }
        // add to buckets
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : frequenceMap.entrySet()) {
            Integer frequency = entry.getValue();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(entry.getKey());
        }
        // get element from buckets
        int[] res = new int[k];
        int cnt = 0;
        outer:
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] == null) continue;
            for (int num : buckets[i]) {
                if (cnt >= k) break outer;
                res[cnt++] = num;
            }
        }
        return res;
    }


}
