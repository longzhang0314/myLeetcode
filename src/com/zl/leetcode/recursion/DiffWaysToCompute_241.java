package com.zl.leetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 241. 为运算表达式设计优先级
 *
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
 *
 * 你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 *
 *
 */
public class DiffWaysToCompute_241 {

    /**
     * 方法1：分治，重复子问题
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute1(String input) {
        if (input == null || input.length() == 0) return new ArrayList<>(0);
        List<Integer> res = new ArrayList<>();
        // 纯数字情况
        int idx = 0;
        int num = 0;
        while (idx < input.length() && !isOperate(input.charAt(idx))) {
            num = num * 10 + input.charAt(idx++) - '0';
        }
        if (idx == input.length()) {
            res.add(num);
            return res;
        }
        // 带有操作符的普遍情况
        for (int i = 0;i < input.length(); i++) {
            if (isOperate(input.charAt(i))) {
                List<Integer> subLeft = diffWaysToCompute1(input.substring(0, i));
                List<Integer> subRight = diffWaysToCompute1(input.substring(i + 1));
                for (int j = 0; j < subLeft.size(); j++) {
                    for (int k = 0; k < subRight.size(); k++) {
                        res.add(calc(subLeft.get(j), input.charAt(i), subRight.get(k)));
                    }
                }
            }
        }
        return res;
    }

    private int calc(int left, char op, int right) {
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
        return c == '+' || c == '-' || c== '*';
    }

    /**
     * 方法2：分治 + 备忘录
     * @param input
     * @return
     */
    Map<String, List<Integer>> memo = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) return new ArrayList<>();
        if (memo.containsKey(input)) return memo.get(input);
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        int num = 0;
        while (idx < input.length() && !isOperate(input.charAt(idx))) {
            num = num * 10 + input.charAt(idx++) - '0';
        }
        if (idx == input.length()) {
            res.add(num);
            memo.put(input, res);
            return res;
        }

        for (int i = 0; i < input.length(); i++) {
            if (isOperate(input.charAt(i))) {
                List<Integer> leftSub = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightSub = diffWaysToCompute(input.substring(i + 1));
                for (int j = 0; j < leftSub.size(); j++) {
                    for (int k = 0; k < rightSub.size(); k++) {
                        res.add(calc(leftSub.get(j), input.charAt(i), rightSub.get(k)));
                    }
                }
            }
        }
        memo.put(input, res);
        return res;
    }

    /**
     * 方法3：方法1 换种写法
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute3(String input) {
        if (input == null || input.length() == 0) return new ArrayList<>(0);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (isOperate(input.charAt(i))) {
                List<Integer> subLeft = diffWaysToCompute(input.substring(0, i));
                List<Integer> subRight = diffWaysToCompute(input.substring(i + 1));
                for (int l : subLeft) {
                    for (int r : subRight) {
                        res.add(calc(l, input.charAt(i), r));
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }
        return res;
    }


    /**
     * 方法4： 方法2换种写法
     * @param input
     * @return
     */
    Map<String, List<Integer>> memo1 = new HashMap<>();
    public List<Integer> diffWaysToCompute4(String input) {
        if (input == null || input.length() == 0) return new ArrayList<>(0);
        if (memo1.containsKey(input)) return memo1.get(input);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (isOperate(input.charAt(i))) {
                List<Integer> subLeft = diffWaysToCompute(input.substring(0, i));
                List<Integer> sunRight = diffWaysToCompute(input.substring(i + 1));
                for (int l : subLeft) {
                    for (int r : sunRight) {
                        res.add(calc(l, input.charAt(i), r));
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.parseInt(input));
        }
        memo1.put(input, res);
        return res;
    }


}
