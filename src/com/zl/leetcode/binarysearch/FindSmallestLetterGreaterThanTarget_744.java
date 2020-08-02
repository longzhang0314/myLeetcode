package com.zl.leetcode.binarysearch;

/**
 * 744.寻找比目标字母大的最小字母
 *
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 *
 */
public class FindSmallestLetterGreaterThanTarget_744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int cur = letters[mid];
            if (cur == target) {
                left = mid + 1;
            } else if (cur < target) {
                left = mid + 1;
            } else if (cur > target) {
                right = mid;
            }
        }
        return left < letters.length ? letters[left] : letters[0];
    }
}
