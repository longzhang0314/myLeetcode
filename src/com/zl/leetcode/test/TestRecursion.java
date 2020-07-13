package com.zl.leetcode.test;

import com.zl.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TestRecursion {


    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) return new ArrayList<>(0);
        List<Integer> res = new ArrayList<>();
        // 考虑纯数字的情况
        int idx = 0;
        int num = 0;
        while (idx < input.length() && !isOperate(input.charAt(idx))) {
            num = num * 10 + input.charAt(idx) - '0';
        }
        if (idx == input.length()) {
            res.add(num);
            return res;
        }
        // 考虑带操作符的情况
        for (int i = 0; i < input.length(); i++) {
            if (isOperate(input.charAt(i))) {
                List<Integer> subLeft = diffWaysToCompute(input.substring(0, i));
                List<Integer> subRight = diffWaysToCompute(input.substring(i + 1));
                for (int j = 0; j < subLeft.size(); j++) {
                    for (int k = 0; k < subRight.size(); k++) {
                        res.add(calc(input.charAt(i), subLeft.get(j), subRight.get(k)));
                    }
                }
            }
        }
        return res;
    }

    private Integer calc(char op, Integer left, Integer right) {
        switch (op) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
        }
        return -1;
    }

    private boolean isOperate(char c) {
        return c == '+' || c == '-' || c == '*';
    }

}
