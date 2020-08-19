package com.zl.leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 128. 最长连续序列
 * Create by zhanglong on 2020/8/18
 */
public class LongestConsecutive_128 {

    /**
     * method1:sort O(nlogn)
     *
     * @param nums
     * @return
     */
    public int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 1, cur =  1, last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) continue;
            if (nums[i] == last + 1) {
                cur++;
                last = last + 1;
            } else {
                max = Math.max(max, cur);
                cur = 1;
                last = nums[i];
            }
        }
        return Math.max(max, cur);
    }


    /**
     * method2 : set + greed
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int max = 1;
        for (int n : nums) {
            // 找到连续的最小值
            if (set.contains(n - 1)) continue;
            int r = n;
            while (set.contains(r + 1)) r++;
            max = Math.max(max, r - n + 1);
        }
        return max;
    }

    /**
     * method3 : 并查集
     * TODO
     * @param nums
     * @return
     */
    public int longestConsecutive3(int[] nums) {
        return -1;
    }
}
