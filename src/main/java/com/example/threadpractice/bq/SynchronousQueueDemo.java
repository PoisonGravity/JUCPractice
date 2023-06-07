package com.example.threadpractice.bq;

import ch.qos.logback.core.joran.conditional.ThenAction;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {

    public static void main(String[] args) {

        BlockingQueue blockingQueue = new SynchronousQueue();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName()+"take 1");
                TimeUnit.SECONDS.sleep(2);
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName()+"take 2");
                TimeUnit.SECONDS.sleep(2);
                blockingQueue.take();
                System.out.println(Thread.currentThread().getName()+"take 3");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }
}
