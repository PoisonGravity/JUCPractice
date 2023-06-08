package com.example.threadpractice.function;

import java.util.function.Predicate;

public class Demo02 {

    public static void main(String[] args) {
//        Predicate<String> predicate = new Predicate<>() {
//            @Override
//            public boolean test(String s) {
//                return s.isEmpty();
//            }
//        };
        Predicate<String> predicate = (s)->{return s.isEmpty();};
        System.out.println(predicate.test("ss"));
    }
}
