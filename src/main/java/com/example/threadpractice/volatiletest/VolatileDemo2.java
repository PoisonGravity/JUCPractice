package com.example.threadpractice.volatiletest;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo2 {

    private volatile static AtomicInteger num = new AtomicInteger();

    public static void add(){
        num.getAndIncrement();
    }

    public static void main(String[] args) {


        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                for (int j = 0; j < 2000; j++) {
                    add();
                }
            }).start();
        }

        while(Thread.activeCount()>2){
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName()+ num);
    }



}
