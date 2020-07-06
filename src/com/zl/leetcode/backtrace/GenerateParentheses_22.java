package com.zl.leetcode.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 *
 * 数字 n 代表生成括号的对数，
 * 请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParentheses_22 {

    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if (n == 0) return res;
        char[] cc = new char[n * 2];
        process(n, cc, 0, 0, 0);
        return res;
    }

    private void process(int n, char[] cc, int l, int r, int idx) {
        if (l == n && r == n) {
            res.add(new String(cc));
            return;
        }
        if (r < l) {
            cc[idx] = ')';
            process(n, cc, l, r + 1, idx + 1);
        }

        if (l < n) {
            cc[idx] = '(';
            process(n, cc, l + 1, r, idx + 1);
        }
    }
}
