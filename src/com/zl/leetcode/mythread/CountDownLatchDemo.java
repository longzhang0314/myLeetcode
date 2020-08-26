package com.zl.leetcode.mythread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch练习
 *
 * Create by zhanglong on 2020/8/26
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        final int totalThreadThread = 5;
        CountDownLatch countDownLatch = new CountDownLatch(totalThreadThread);
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThreadThread; i++) {
            executor.execute(() -> {
                System.out.println("run..");
                countDownLatch.countDown();
            });
        }
        // await方法会一致阻塞，直到计数器减为0被唤醒
        countDownLatch.await();
        System.out.println("end..");
        executor.shutdown();
    }
}
