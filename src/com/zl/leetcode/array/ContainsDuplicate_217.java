package com.zl.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 217.
 * Create by zhanglong on 2020/8/14
 */
public class ContainsDuplicate_217 {

    /**
     * 1.
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) return false;
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int n : nums) {
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > 1) return true;
        }
        return false;
    }
}
