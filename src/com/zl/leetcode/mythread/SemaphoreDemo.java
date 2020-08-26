package com.zl.leetcode.mythread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore练习
 * <p>
 * Create by zhanglong on 2020/8/26
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
        final int clientCount = 3;
        final int totalRequestCount = 10;
        // 最大并发数为clientCount
        Semaphore semaphore = new Semaphore(clientCount);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalRequestCount; i++) {
            executorService.execute(()->{
                try {
                    // 获取信号量，相当于获取锁
                    semaphore.acquire();
                    System.out.print(semaphore.availablePermits() + " ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 信号量释放
                    semaphore.release();
                }
            });
        }
        executorService.shutdown();
    }
}