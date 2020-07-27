package com.zl.leetcode.twopointer;

/**
 * 88. 归并两个有序数组
 *
 * 把归并结果存到第一个数组上。
 * Create by zhanglong on 2020/7/27
 */
public class MergeSortedArray_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mergeIndex = m + n - 1;
        int mIndex = m - 1;
        int nIndex = n - 1;
        while (mIndex >= 0 || nIndex >= 0) {
            if (mIndex < 0) {
                nums1[mergeIndex--] = nums2[nIndex--];
            } else if (nIndex < 0) {
                nums1[mergeIndex--] = nums1[mIndex--];
            } else if (nums1[mIndex] > nums2[nIndex]) {
                nums1[mergeIndex--] = nums1[mIndex--];
            } else {
                nums1[mergeIndex--] = nums2[nIndex--];
            }
        }
    }
}
