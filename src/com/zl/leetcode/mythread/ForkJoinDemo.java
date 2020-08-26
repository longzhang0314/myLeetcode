package com.zl.leetcode.mythread;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Fork/Join练习
 * Create by zhanglong on 2020/8/26
 */
public class ForkJoinDemo extends RecursiveTask<Integer> {

    // 最小任务规模
    private final int threshold = 5;
    private int first;
    private int last;

    public ForkJoinDemo(int first, int last) {
        this.first = first;
        this.last = last;
    }


    @Override
    protected Integer compute() {
        int res = 0;
        if (last - first <= threshold) {
            for (int i = first; i <= last; i++) {
                System.out.println(i);
                res += i;
            }
        } else {
            int mid = (first + last) >>> 1;
            ForkJoinDemo leftTask = new ForkJoinDemo(first, mid);
            ForkJoinDemo rightTask = new ForkJoinDemo(mid + 1, last);
            leftTask.fork();
            rightTask.fork();
            res = leftTask.join() + rightTask.join();
        }
        return res;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(1, 100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> submit = forkJoinPool.submit(forkJoinDemo);
        System.out.println(submit.get());
    }
}
