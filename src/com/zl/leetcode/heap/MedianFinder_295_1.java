package com.zl.leetcode.heap;

import java.util.PriorityQueue;

/**
 * 295.
 *
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 *
 * Create by zhanglong on 2020/8/15
 */
public class MedianFinder_295_1 {

    public static void main(String[] args) {
        MedianFinder_295_1 t = new MedianFinder_295_1();
        t.addNum(1);
        t.addNum(2);
        double median = t.findMedian();
        System.out.println(median);
        t.addNum(3);
        double median2 = t.findMedian();
        System.out.println(median2);
    }

    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    private int count;

    /** initialize your data structure here. */
    public MedianFinder_295_1() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>((v1, v2) -> v2 - v1);
    }

    public void addNum(int num) {
        count++;
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if ((count & 1) == 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (count == 0) return 0;
        if ((count & 1) == 1) {
            return (double) maxHeap.peek();
        } else {
            return (double) (maxHeap.peek() + minHeap.peek()) / 2;
        }
    }


}
