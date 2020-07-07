package com.zl.leetcode.recursion;

/**
 * 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = {3,4,7,9,5,2,-1};
        MergeSort test = new MergeSort();
        test.mergeSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, lo, mid);
        mergeSort(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    private void merge(int[] nums, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        int[] tmp = new int[hi - lo + 1];
        int cnt = 0;
        while (i <= mid && j <= hi) {
            if (nums[i] <= nums[j]) {
                tmp[cnt++] = nums[i++];
            } else {
                tmp[cnt++] = nums[j++];
            }
        }
        while (i <= mid) tmp[cnt++] = nums[i++];
        while (j <= hi) tmp[cnt++] = nums[j++];

        for (i = 0; i < cnt; i++) {
            nums[lo + i] = tmp[i];
        }
    }
}
