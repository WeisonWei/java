package com.weison.jmh;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Benchmark                Mode  Cnt  Score   Error   Units
 * ForJmh.forEach          thrpt    3  1.797 ± 3.052  ops/ns
 * ForJmh.forI             thrpt    3  2.057 ± 0.159  ops/ns
 * ForJmh.parallelStream   thrpt    3  0.035 ± 0.001  ops/ns
 * ForJmh.parallelStream1  thrpt    3  0.035 ± 0.005  ops/ns
 * ForJmh.stream           thrpt    3  0.119 ± 0.012  ops/ns
 */
public class ForJmh {

    private static final List<Integer> ls = new ArrayList<>(1000000);

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(ForJmh.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @State(Scope.Benchmark)
    public static class SharedState {
        @Setup
        public void setupOnTrial() {
            for (int i = 0; i < 1000000; i++) {
                ls.add(i);
            }
            System.out.println("before trial");
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 10)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void forI() {
        for (int i = 0; i < 1000000; i++) {
        }
    }
    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 10)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void forEach() {
        ls.forEach(i -> {});
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 10)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void stream() {
        ls.stream().forEach(i -> {});
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 10)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void parallelStream() {
        ls.stream().parallel().forEach(i -> {});
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @Warmup(iterations = 10)
    @Measurement(iterations = 3)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    public void parallelStream1() {
        ls.parallelStream().forEach(i -> {});
    }
}
