package com.zl.leetcode.heap;

import java.util.PriorityQueue;

/**
 * 295. 方法1：小顶堆  超时
 * <p>
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 * <p>
 * Create by zhanglong on 2020/8/14
 */
public class MedianFinder_295 {

    public static void main(String[] args) {
        MedianFinder_295 t = new MedianFinder_295();
        t.addNum(1);
        t.addNum(2);
        double median = t.findMedian();
        System.out.println(median);
        t.addNum(3);
        double median2 = t.findMedian();
        System.out.println(median2);
    }

    private PriorityQueue<Integer> heap;
    private PriorityQueue<Integer> temp;
    private int[] nums;

    /**
     * initialize your data structure here.
     */
    public MedianFinder_295() {
        this.heap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        heap.offer(num);
    }

    public double findMedian() {
        if (heap.isEmpty()) return 0;
        temp = new PriorityQueue<>();
        this.nums = new int[heap.size()];
        int idx = 0;
        while (!heap.isEmpty()) {
            int val = heap.poll();
            temp.offer(val);
            nums[idx++] = val;
        }

        PriorityQueue<Integer> t = heap;
        this.heap = temp;
        this.temp = t;
        if (idx == 1) return nums[0];
        if ((idx & 1) == 1) {
            return nums[idx / 2];
        } else {
            int i = idx / 2;
            int j = i - 1;
            return ((double) nums[i] + (double) nums[j]) / 2;
        }
    }

}
