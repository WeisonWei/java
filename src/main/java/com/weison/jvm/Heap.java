package com.weison.jvm;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Heap {

    /**
     * 工具
     * 1. jvisualvm 命令打开工具 查看 visualGC
     * 2. Arthas 1.java -jar arthas-boot.jar 2.选择线程 3.dashboard 4.thread tId 5.optional jad反编译
     *
     * @param args
     */
    @SneakyThrows
    public static void main(String[] args) {
        List<Size25Kb> list = new ArrayList<>();
        for (; ; ) {
            list.add(new Size25Kb());
            TimeUnit.MILLISECONDS.sleep(1);
        }
    }

    static class Size25Kb {
        byte[] bytes = new byte[1024 * 25]; //25KB
    }
}
