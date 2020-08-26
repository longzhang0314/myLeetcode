package com.zl.leetcode.mythread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CycliBarrier练习
 * 相比于CountDownLatch，可以重复利用，从计数点减为0，然后重置为计数点
 *
 * Create by zhanglong on 2020/8/26
 */
public class CycliBarrierDemo {

    public static void main(String[] args) {
        final int total = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(total);
        ExecutorService executor = Executors.newCachedThreadPool();
        // 以total个为一组完成任务
        for (int i = 1; i <= total * 2; i++) {
            int finalI = i;
            executor.execute(() -> {
                System.out.println("start: " + finalI);
                // 调用await方法计数器-1, 0后重置为total
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("end: " + finalI);
            });
        }
        // 猜测执行结果 start: 1,..start: 5, end: 1,..end: 5
        // 实际执行，5个start,然后5个end,但是不一定是1-5；因为线程是抢占式执行的

        // 将i的上限改为total * 2
        // 20此输出中，前5个是start, 最后5个是end, 中间会乱序执行；
        // 原因是前5个需要使计数器值为5，end才能执行下去，能执行的end和新的start又有抢占关系导致中间乱序；最后5个一定为end
        executor.shutdown();
    }


}
