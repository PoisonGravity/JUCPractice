package com.example.threadpractice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ThreadPracticeApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
