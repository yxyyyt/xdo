package com.sciatta.xdo.lib.hutool.tool;

import cn.hutool.core.lang.Console;
import cn.hutool.core.thread.ConcurrencyTester;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.RandomUtil;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Rain on 2024/1/30<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * ThreadTests
 */
public class ThreadTests {
    @Test
    public void testNewThreadFactory() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        ThreadUtil.createThreadFactory("thread-tests")
                .newThread(() -> {
                    ThreadUtil.sleep(2000);
                    latch.countDown();
                }).start();

        latch.await();
    }

    @Test
    public void testNewThread() throws InterruptedException {
        CountDownLatch latch = ThreadUtil.newCountDownLatch(1);

        Thread thread = ThreadUtil.newThread(() -> {
            ThreadUtil.sleep(2000);
            latch.countDown();
        }, "new-thread", true);

        thread.start();

        latch.await();
    }

    @Test
    public void testMoreThreadExecuteSomething() throws InterruptedException {
        int threadNum = 10;
        CountDownLatch latch = ThreadUtil.newCountDownLatch(threadNum);

        ConcurrencyTester tester = ThreadUtil.concurrencyTest(10, () -> {
            long l = RandomUtil.randomLong(100, 2000);
            ThreadUtil.sleep(l);
            Console.log("{} cost {}ms", Thread.currentThread().getName(), l);
            latch.countDown();
        });

        latch.await();
        Console.log("total cost: {}ms", tester.getInterval());
    }
}
