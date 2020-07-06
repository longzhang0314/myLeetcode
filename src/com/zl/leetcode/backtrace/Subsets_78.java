package com.zl.leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 78.求子集
 * <p>
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 */
public class Subsets_78 {

    List<List<Integer>> res;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        process(nums, new ArrayList<>(), 0);
        return res;
    }

    private void process(int[] nums, ArrayList<Integer> single, int start) {
        // 当前start元素不放入
        res.add(new ArrayList<>(single));
        for (int i = start; i < nums.length; i++) {
            // 当前start元素放入
            single.add(nums[i]);
            // 考察下一个元素
            process(nums, single, i + 1);
            // 清理现场
            single.remove(single.size() - 1);
        }
    }


}
