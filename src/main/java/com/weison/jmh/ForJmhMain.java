package com.weison.jmh;

import org.openjdk.jmh.runner.RunnerException;

public class ForJmhMain {

    public static void main(String[] args) throws RunnerException {
        long start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
        }
        System.out.println(System.nanoTime() - start);

    }
}
