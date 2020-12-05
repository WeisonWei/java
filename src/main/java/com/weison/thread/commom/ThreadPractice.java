package com.weison.thread.commom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThreadPractice extends Thread {

    private CountDownLatch countDownLatch;

    @Override
    public void run() {
        try {
            log.debug("Thread -run- status:{}",Thread.currentThread().getState());
            TimeUnit.SECONDS.sleep(10);
            log.info("线程执行中...");
            this.wait();
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}