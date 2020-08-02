package com.zl.leetcode.test.test0802;

import java.util.ArrayList;
import java.util.List;

public class TestBackTrace {

    public static void main(String[] args) {

    }

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * @param n
     * @param k
     * @return
     */
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0 || n < k) return new ArrayList<>();
        res = new ArrayList<>();
        helper(n, k, new ArrayList<Integer>(), 1);
        return res;
    }

    private void helper(int n, int k, ArrayList<Integer> list, int start) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(n, k, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
