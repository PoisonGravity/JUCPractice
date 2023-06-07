package com.example.threadpractice.add;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"Thread Get out");
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await();

        System.out.println("Close Door");
    }
}
