package com.zl.leetcode.mythread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger线程安全性验证
 * Create by zhanglong on 2020/8/26
 */
public class AtomicIntegerDemo {

    public static void main(String[] args) throws InterruptedException {
        final int total = 10000;
        AtomicInteger ai = new AtomicInteger();
        CountDownLatch countDownLatch = new CountDownLatch(total);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < total; i++) {
            executorService.execute(() -> {
                ai.incrementAndGet();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(ai.get()); // 10000，证明线程安全
    }
}
