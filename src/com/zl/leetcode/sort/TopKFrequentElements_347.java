package com.zl.leetcode.sort;

import java.util.*;

/**
 * 347.
 * Create by zhanglong on 2020/7/28
 */
public class TopKFrequentElements_347 {


    /**
     * 1.
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent1(int[] nums, int k) {
        // frequency dict
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        // small top head
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (heap.size() == k) {
                if (heap.peek().getValue() < entry.getValue()) {
                    heap.poll();
                } else {
                    continue;
                }
            }
            heap.offer(entry);
        }

        // poll from heap
        int[] res = new int[k];
        int cnt = 0;
        while (!heap.isEmpty()) {
            res[cnt++] = heap.poll().getKey();
        }
        return res;
    }


    /**
     * 2.
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> frequenceMap = new HashMap<>();
        for (int n : nums) {
            frequenceMap.put(n, frequenceMap.getOrDefault(n, 0) + 1);
        }

        // 同一频率的放在一个桶中
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : frequenceMap.keySet()) {
            int frequence = frequenceMap.get(key);
            if (buckets[frequence] == null) {
                buckets[frequence] = new ArrayList<>();
            }
            buckets[frequence].add(key);
        }

        int[] res = new int[k];
        int cnt = 0;
        outer:
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] == null) continue;
            for (int ele : buckets[i]) {
                if (cnt == k) break outer;
                res[cnt++] = ele;
            }
        }
        return res;
    }


}
