package com.zl.leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 46.全排列
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class Permutations_46 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        process(nums, new ArrayList<>());
        return res;
    }

    private void process(int[] nums, ArrayList<Integer> single) {
        if (single.size() == nums.length) {
            res.add(new ArrayList<>(single));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (single.contains(nums[i])) continue;
            single.add(nums[i]);
            process(nums, single);
            single.remove(single.size() - 1);
        }
    }
}
