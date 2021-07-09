package com.weison;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

public class AtomTest {

    private static final AtomicLong al = new AtomicLong();
    public static void main(String[] args) {
        long l = al.longValue();
        long andAdd = al.getAndAdd(123123);
        long l1 = al.addAndGet(112312);
        long l2 = al.incrementAndGet();
        long l3 = al.decrementAndGet();
        long l4 = System.nanoTime();
        long l5 = al.decrementAndGet();
        long l6 = System.nanoTime();
        long l7 = l6 - l4;
        float v = BigDecimal.valueOf(l7)
                .divide(BigDecimal.valueOf(111L),4, BigDecimal.ROUND_HALF_UP)
                .floatValue();
        System.out.println();
    }
}
