package com.example.threadpractice.single;

public class LazyMan {

    private LazyMan(){
        System.out.println(Thread.currentThread().getName() + "ok");
    }

    private volatile static LazyMan lazyMan;

    //双重检测锁模式
    public static LazyMan getInstance(){
        if(lazyMan == null){
            synchronized (LazyMan.class){
                if(lazyMan == null){
                    lazyMan = new LazyMan();//不是原子操作
                    /**
                     * 1。分配内存空间
                     * 2。执行构造方法，初始化对象
                     * 3。把这个对象指向这个空间
                     */
                }
            }
        }
        return lazyMan;
    }

    //多线程并发
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                LazyMan.getInstance();
            }).start();
        }
    }
}
