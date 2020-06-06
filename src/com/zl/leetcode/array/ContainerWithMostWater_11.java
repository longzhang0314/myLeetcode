package com.zl.leetcode.array;

/**
 * 盛水最多的容器
 *
 * 容积 = 数组索引之差 * 较小的索引对应的值
 */
public class ContainerWithMostWater_11 {

    /**
     * 方法2：两边收缩，每次将较小值所在侧进行移动，保证剩下的值较大
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int n = height.length;
        int res = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                res = Math.max(res, height[left] * (right - left));
                left++;
            } else {
                res = Math.max(res, height[right] * (right - left));
                right--;
            }
        }
        return res;
    }

    /**
     * 方法1：暴力法
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int n = height.length;
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != j) {
                    res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
                }
            }
        }
        return res;
    }


}
