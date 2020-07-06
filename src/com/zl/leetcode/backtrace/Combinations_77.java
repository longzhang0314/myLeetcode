package com.zl.leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combinations_77 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0 || k > n) return res;
        process(n, k, 1, new ArrayList<Integer>());
        return res;
    }

    private void process(int n, int k, int start, ArrayList<Integer> sin) {
        // 对树的高度有限制的一种特殊子集(78)问题
        if (sin.size() == k) {
            res.add(new ArrayList<>(sin));
            return;
        }
        for (int i = start; i <= n; i++) {
            sin.add(i);
            process(n ,k , i + 1, sin);
            sin.remove(sin.size() - 1);
        }
    }
}
