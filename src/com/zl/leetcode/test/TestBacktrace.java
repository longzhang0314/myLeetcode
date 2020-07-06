package com.zl.leetcode.test;

import java.util.ArrayList;
import java.util.List;

public class TestBacktrace {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> get(int[] nums) {
        process(nums, 0, new ArrayList<>());
        return res;
    }

    private void process(int[] nums, int start, ArrayList<Integer> sin) {
        res.add(new ArrayList<>(sin));
        for (int i = start; i < nums.length; i++) {
            sin.add(nums[i]);
            process(nums, i + 1, sin);
            sin.remove(sin.size() - 1);
        }
    }
}
