package com.sciatta.xdo.algo.zcy.support;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Rain on 2024/2/2<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * ExecuteUtil
 */
public class ExecuteUtil {
    /**
     * 执行一百万次
     */
    public static final int MILLION_TIMES = 1000000;

    public static void execute(Runnable runnable, int threads, int times) {
        AtomicLong l = new AtomicLong(0);
        long start = System.currentTimeMillis();

        CountDownLatch latch = new CountDownLatch(threads);

        for (int i = 0; i < threads; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < times; j++) {
                        runnable.run();
                        l.incrementAndGet();
                    }
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        PrintUtil.log("{} threads run {} times in total, cost {}ms",
                threads, l.get(), (System.currentTimeMillis() - start));
    }

    public static void sleep(int ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(ms);
        } catch (InterruptedException ignore) {
        }
    }

    public static void shutdown() {
        System.exit(0);
    }
}
