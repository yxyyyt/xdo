package com.sciatta.xdo.lib.hutool.tool;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.cron.CronUtil;
import cn.hutool.cron.task.Task;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Rain on 2024/1/31<br>
 * All Rights Reserved(C) 2017 - 2024 SCIATTA <br> <p/>
 * CronTests
 */
public class CronTests {

    @Test
    public void testCron() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        // 每5秒执行一次
        CronUtil.schedule("*/5 * * * * *", (Task) () -> {
            Console.log("{} executed.", DateUtil.now());
            latch.countDown();
        });

        // 支持秒级别定时任务
        CronUtil.setMatchSecond(true);
        CronUtil.start();

        latch.await();
    }
}
