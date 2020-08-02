package com.zl.leetcode.binarysearch;

/**
 * 278.第一个错误的版本
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 */
public class FirstBadVersion_278 {


    public int firstBadVersion(int n) {
        if (n == 1) return 1;
        int left = 1, right = n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    private boolean isBadVersion(int version) {
        return false;
    }
}
