package com.weison.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

public class Simple {

    /**
     * @BenchmarkMode： 测试类型，有以下几种可选：
     * Throughput：吞吐量，即每秒执行可多少次
     * AverageTime：平均时间，即每次调用平均耗时
     * SampleTime：随机取样
     * SingleShotTime：顾名思义，只运行一次，一般用于测试冷启动性能
     * All：小朋友才做选择
     * @Warmup：预热，一般为保证测试准确性，要预热几次
     * @Measurement：测量
     * iterations：测试多少轮
     * time：每轮时长
     * timeUnit：时间单位
     * @Fork：JMH fork出指定个数的进程测试
     * @Threads：每个测试进程的测试线程数量
     * @OutputTimeUnit：测试结果的时间单位
     * @Benchmark：标记某个方法进行基准测试，类比JUnit的@Test
     * @Param：指定同一个方法的不同参数
     * @State：标记某对象在指定Scope内共享，通过@Benchmark标记的方法参数注入，Scope分三种：
     * Benchmark，所有线程共享实例
     * Group，线程组内共享实例
     * Thread，线程内共享实例
     * @Setup：配置了@State的类专用，类比JUnit的@Setup，在benchmark方法执行前state实例做的操作
     * @TearDown：配置了@State的类专用，类比JUnit的@TearDown，在benchmark方法执行后state实例做的操作
     */
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Simple.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @State(Scope.Benchmark)
    public static class SharedState {
        @Setup
        public void setupOnTrial() {
            System.out.println("before trial");
        }

        @Setup(Level.Iteration)
        public void setupOnIteration() {
            System.out.println("before iteration");
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 1)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public double f(SharedState sharedState) {
        return Math.log(Math.PI);
    }

    /**
     * 要测试的方法上打注解@Benchmark
     */
    //@Benchmark
    public void wellHelloThere() {
        // this method was intentionally left blank.
    }

}
