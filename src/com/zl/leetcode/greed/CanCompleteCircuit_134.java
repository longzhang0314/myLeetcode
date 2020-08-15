package com.zl.leetcode.greed;

/**
 * 134.
 * Create by zhanglong on 2020/8/15
 */
public class CanCompleteCircuit_134 {

    public static void main(String[] args) {

    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalTank = 0;
        int curTank = 0;
        int startIdx = 0;
        for (int i = 0; i < n; i++) {
            totalTank += gas[i] - cost[i];
            curTank += gas[i] - cost[i];
            if (curTank < 0) {
                startIdx = i + 1;
                curTank = 0;
            }
        }
        return totalTank < 0 ? -1 : startIdx;
    }
}
