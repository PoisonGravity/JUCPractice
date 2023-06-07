package com.example.threadpractice.rwlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {

        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                myCache.put(Thread.currentThread().getName(), Thread.currentThread().getName() + "vv");
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                myCache.get(Thread.currentThread().getName());
            }).start();
        }

    }
}


class MyCache {

    private Map<String, String> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, String value) {

        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "执行写操作");
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "执行写操作完毕");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "执行读操作");
            map.get(key);
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName() + "执行读操作完毕");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}
