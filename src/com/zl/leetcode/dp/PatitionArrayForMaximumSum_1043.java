package com.zl.leetcode.dp;

/**
 * 1043. 分隔数组以得到最大值
 *
 * TODO
 * Create by zhanglong on 2020/6/15
 */
public class PatitionArrayForMaximumSum_1043 {

    /**
     * 方法1：递归穷举
     * @param A
     * @param K
     * @return
     */
    public int maxSumAfterPartitioning(int[] A, int K) {
        return maxSum(A, K, 0);
    }
    private int maxSum(int[] A, int K, int idx) {
        int maxVal = 0;
        int maxSum = 0;
        // 以i + 1个数为一组
        int i = 0;
        for (; i < K && idx + i < A.length; i++) {
            maxVal = Math.max(maxVal, A[i + idx]);
            maxSum = Math.max(maxSum, (i + 1) * maxVal + maxSum(A, K, idx + i + 1));
        }
        return maxSum;
    }


}
