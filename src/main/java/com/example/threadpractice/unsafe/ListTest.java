package com.example.threadpractice.unsafe;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {

    public static void main(String[] args) {
        List<Object> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
