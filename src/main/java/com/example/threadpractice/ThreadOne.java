package com.example.threadpractice;

public class ThreadOne extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学洗" + i);
        }
    }

    public static void main(String[] args) {

        ThreadOne threadOne = new ThreadOne();
        threadOne.start();


        for (int i = 0; i < 20; i++) {
            System.out.println("看代码" + i);
        }
    }
}
