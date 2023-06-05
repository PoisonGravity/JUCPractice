package com.example.threadpractice.pc;

public class PcSynchronized {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    data.increment();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "A").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    data.decrement();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "B").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    data.increment();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "C").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    data.decrement();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "D").start();

    }
}


class Data {
    private int number = 0;

    public synchronized void increment() throws InterruptedException {
        while (number != 0) {
            wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "线程执行incre，number为" + number);
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException {
        while (number == 0) {
            wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "线程执行decre，number为" + number);
        this.notifyAll();
    }
}
