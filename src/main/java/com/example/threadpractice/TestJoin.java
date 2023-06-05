package com.example.threadpractice;

public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {
            System.out.println("vip" + i);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        for (int i = 0; i < 300; i++) {
            if(i == 200){
                thread.join();
            }
            System.out.println("主线程" + i);
        }
    }
}



