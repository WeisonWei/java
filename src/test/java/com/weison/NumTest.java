package com.weison;

import java.io.File;
import java.math.BigDecimal;

public class NumTest {
    public static void main(String[] args) {
        divide();
    }

    public static void divide() {
        float v = floatDivide(1, 2);
        float v1 = floatDivide(3, 2);
        float v2 = floatDivide(0, 2);
        float v3 = floatDivide(3, 0);
        System.out.println();
    }

    private static float floatDivide(long a, long b) {
        return BigDecimal.valueOf(a)
                .divide(BigDecimal.valueOf(b))
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                .floatValue();
    }

    public static void forNum() {
        for (int i = 80000; i < 100000; i++) {
            String path = File.separator + System.currentTimeMillis() + i + File.separator + i;
            System.out.println(path);
        }
    }

}
