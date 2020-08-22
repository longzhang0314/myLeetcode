package com.zl.leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 560. 和为k的子数组
 * Create by zhanglong on 2020/8/20
 */
public class SubarraySum_560 {



    /**
     * method 1: brute force O(N^3)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int p = i; p <= j; p++) {
                    sum += nums[p];
                }
                if (sum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    /**
     * method2: optimized brute force O(N^2)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == k) cnt++;
            }
        }
        return cnt;
    }

    /**
     * method3 : prefix sum O(N^2), space O(N)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum3(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        // prefix sum array
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == 0 && preSum[j] == k) cnt++;
                else if (i > 0 && preSum[j] - preSum[i - 1] == k) cnt++;
            }
        }
        return cnt;
    }

    /**
     * method3_1: preSum[] n+1
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum3_1(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        // prefix sum array
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) { // [i, j)
                // sum[i, j) = preSum[j] - preSum[i] = [0, j) - [0, i)
                if (preSum[j] - preSum[i] == k) sum++;
                // preSum[i] = preSum[j] - k
            }
        }
        return sum;
    }



    /**
     * method4 : prefix sum + hashMap O(N), space O(N)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum4(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        // key prefix sum , value count
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num; // 5 , k = 2, 3
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] ss = input.split(" ");
        int len = ss[ss.length - 1].length();
        System.out.println(len);
    }
}
