package com.zl.leetcode.sort.test;

/**
 * Create by zhanglong on 2020/8/7
 */
public class TestSort1 {

    public static void main(String[] args) {
        TestSort1 sort1 = new TestSort1();
        int[] nums = {4,11,1,9,-1};
        sort1.selectSort(nums);
        for (int n : nums) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    private void selectSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int insert = nums[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (nums[j] > insert) {
                    nums[j + 1] = nums[j];
                }
            }
            nums[j + 1] = insert;
        }
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
