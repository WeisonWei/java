package com.weison;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class TimeTest {

    @Test
    public void NanosTest() throws InterruptedException {
        long l = System.nanoTime();
        long l1 = System.currentTimeMillis();
        TimeUnit.NANOSECONDS.sleep(10);
        long l2 = System.nanoTime();
        long l3 = System.currentTimeMillis();

        long l4 = l2 - l;
        long l5 = l3 - l1;
        if (l2 > 10) {
            System.out.println(">>>>>>l2 > 10>>>>>>>>");
        }
    }
}
