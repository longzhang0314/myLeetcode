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
        Arrays.sort(nums);
        int[] res = new int[k];
        res[0] = nums[0];
        int idx = 1;
        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == tmp) continue;
            tmp = nums[i];
            res[idx++] = nums[i];
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
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> frequenceMap = new HashMap<>();
        for (int n : nums) {
            frequenceMap.put(n, frequenceMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int n : nums) {
            if (heap.size() == k) {
                if (frequenceMap.get(heap.peek()) > frequenceMap.get(n)) {
                    continue;
                }
                heap.poll();
            }
            heap.offer(n);
        }

        int[] res = new int[k];
        int idx = 0;
        while (!heap.isEmpty()) {
            res[idx++] = heap.poll();
        }
        return res;
    }


    /**
     * 3.
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
        wc:
        for (int i = buckets.length - 1; i > 0; i--) {
            if (buckets[i] == null) continue;
            for (int ele : buckets[i]) {
                if (cnt == k) break wc;
                res[cnt++] = ele;
            }
        }
        return res;
    }


}
