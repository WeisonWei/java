package com.weison.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AboutThreadLocal {

    private static ThreadLocal<StringBuffer> ts = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            return new StringBuffer("haha");
        }
    };

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(getFuck(index));
        }
    }

    private static Runnable getFuck(int index) {
        return () -> {
            try {
                if (index % 2 == 0) {
                    ts.set(new StringBuffer("fuck"));
                }
                TimeUnit.SECONDS.sleep(2);
                StringBuffer stringBuffer = ts.get();
                System.out.println("---" + index + "--->" + stringBuffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
