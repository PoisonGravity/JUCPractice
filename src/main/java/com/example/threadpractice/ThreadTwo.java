package com.example.threadpractice;

public class ThreadTwo implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学洗" + i);
        }
    }

    public static void main(String[] args) {
        ThreadTwo threadTwo = new ThreadTwo();
        new Thread(threadTwo).start();
        for (int i = 0; i < 20; i++) {
            System.out.println("看代码" + i);
        }
    }
}
