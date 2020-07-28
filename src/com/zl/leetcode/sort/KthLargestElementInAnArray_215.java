package com.zl.leetcode.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. 找到第K大元素，且K总是有效
 * Create by zhanglong on 2020/7/28
 */
public class KthLargestElementInAnArray_215 {

    public static void main(String[] args) {
        KthLargestElementInAnArray_215 test = new KthLargestElementInAnArray_215();
        int[] nums = {2,4,1,6,3};
        int i = test.findKthLargest(nums, 2);
        System.out.println(i);
    }

    /**
     * 1.
     * @param nums
     * @param k
     * @return 1,2,3,4,5
     */
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 2.
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        // k个元素的小顶堆，堆顶元素即为所求，装满后不再放入
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int num : nums) {
            if (heap.size() == k) {
                if (heap.peek() < num) {
                    heap.poll();
                } else {
                    continue;
                }
            }
            heap.offer(num);
        }
        return heap.peek();
    }

    /**
     * 3.
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        // 第k大即为第nums.length - k + 1小，转化为索引表示即nums.length - k
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = patition(nums, l, h);
            if (k == j) {
                break;
            } else if (k < j) {
                h = j - 1;
            } else {
                l = j + 1;
            }
        }
        return nums[k];
    }

    private int patition(int[] nums, int l, int h) {
        int pivot = nums[h];
        int i = l;
        for (int j = l; j < h; j++) {
            if (nums[j] < pivot) {
                if (i != j) {
                    swap(nums, i, j);
                }
                i++;
            }
        }
        swap(nums, i, h);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
