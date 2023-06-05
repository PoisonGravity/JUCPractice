package com.example.threadpractice;

public class TestYield {

    public static void main(String[] args) {
        MyYield myYield1 = new MyYield();
        MyYield myYield2 = new MyYield();

        new Thread(myYield1).start();
        new Thread(myYield2 ).start();

    }

}

class MyYield implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}
