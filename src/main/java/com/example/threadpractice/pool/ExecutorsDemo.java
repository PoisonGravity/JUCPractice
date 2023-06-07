package com.example.threadpractice.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {

    public static void main(String[] args) {

        ExecutorService pool = Executors.newSingleThreadExecutor();
        ExecutorService pool2 = Executors.newFixedThreadPool(5);
        ExecutorService pool3 = Executors.newCachedThreadPool();


        try {
                for (int i = 0; i < 100; i++) {
                    pool2.execute(() -> {
                        System.out.println(Thread.currentThread().getName() + "ok");
                    });
                }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool2.shutdown();
        }


    }


}
