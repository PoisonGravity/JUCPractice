package com.example.threadpractice.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyThread myThread =new MyThread();
        FutureTask futureTask =new FutureTask(myThread);
        new Thread(futureTask).start();
        Integer res = (Integer) futureTask.get();
        System.out.println(res);

    }

}


class MyThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("call()");
        return 1024;
    }
}

