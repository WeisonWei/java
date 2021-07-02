package com.weison.schdule;

import lombok.SneakyThrows;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class AboutTimer {

    @SneakyThrows
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask timerTask = newTimerTask(2);
        timer.schedule(timerTask,100);
        TimeUnit.MILLISECONDS.sleep(101);
        //timer.cancel();
        timerTask.cancel();
    }

    private static TimerTask newTimerTask(int condition) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                if (1 < condition) {
                    System.out.println("condition is get");
                }
            }
        };
        return timerTask;
    }
}
