package com.zl.leetcode.mythread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 使用BlockQueue实现生产者消费者问题
 * <p>
 * Create by zhanglong on 2020/8/26
 */
public class ProducerConsumer {

    private static final BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Produce produce = new Produce();
            produce.start();
        }
        for (int i = 0; i < 5; i++) {
            Consumer consumer = new Consumer();
            consumer.start();
        }
        for (int i = 0; i < 3; i++) {
            Produce produce = new Produce();
            produce.start();
        }
    }

    private static class Produce extends Thread {
        @Override
        public void run() {
            try {
                // 采用阻塞方式给队列添加元素
                queue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("produce..");
        }
    }

    private static class Consumer extends Thread {
        @Override
        public void run() {
            try {
                // 使用阻塞方式从队列中获取元素
                String msg = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("consume..");
        }
    }
}
